/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.acceso;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.comun.sha1;
import ec.gob.uideh.dao.agentes.UsuariosDao;
import ec.gob.uideh.dao.parametros.UsuariosRolesDao;
import ec.gob.uideh.dao.seguridad.MenuItemsDao;
import ec.gob.uideh.dao.seguridad.UserRolMenuDao;
import ec.gob.uideh.dao.seguridad.UsuarioMenuDao;
import ec.gob.uideh.menu.entidades.Menuitems;
import ec.gob.uideh.menu.entidades.UserRolMenu;
import ec.gob.uideh.menu.entidades.UsuarioMenu;
import ec.gob.uideh.menu.entidades.Usuarios;
import ec.gob.uideh.menu.entidades.UsuariosRoles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class Autenticar extends Comun {

    private HttpSession sessionIniciada;
    @EJB
    private UsuariosDao usuariosDao;
    @EJB
    MenuItemsDao menuItemsDao;
    @EJB
    UsuariosRolesDao usuariosRolesDao;
    @EJB
    UserRolMenuDao userRolMenuDao;
    @EJB
    UsuarioMenuDao usuarioMenuDao;

    private Usuarios usuario;
    String login;
    String passw;
    private Long totalNodos = new Long(0);
    private MenuModel defaultMenuModel;
    private Long validMenu;
    private List<Menuitems> userRolmenuItemsTmp;
    private List<Menuitems> UserMenuItemsTmp;
    private List<Menuitems> auxListMenu;

    @PostConstruct
    private void inicia() {
        this.sessionIniciada = getRequest().getSession();
    }

    public Autenticar() {
        this.defaultMenuModel = new DefaultMenuModel();
        this.userRolmenuItemsTmp = new ArrayList<Menuitems>();
        this.UserMenuItemsTmp = new ArrayList<Menuitems>();
        auxListMenu = new ArrayList<Menuitems>();
    }

    public String ingresar() {
        usuario = new Usuarios();
        try {
            if (this.getLogin().isEmpty() || this.getPassw().isEmpty() || this.getLogin() == null || this.getPassw() == null) {
                ponerMensajeAlerta(INGRESE_USUARIO_CLAVE);
            } else {
                Usuarios usuario = new Usuarios();
                usuario.setUsuario(this.getLogin());
                usuario.setContrasena(sha1.encrypt64(this.getPassw()));
                this.usuario = usuariosDao.obtenerUsuario(usuario);
                if (this.usuario != null && this.usuario.getEstado() != null && this.usuario.getEstado().getId().equals(ESTADO_INACTIVO)) {
                    ponerMensajeAlerta(USUARIO_INACTIVO + ": " + this.usuario.getEstado().getId());
                } else {
                    if (this.usuario == null) {
                        ponerMensajeAlerta(NO_USUARIO);
                    } else {
                        this.setLogin(null);
                        this.setPassw(null);
                        this.adminMenu();
                        return "home.xhtml?faces-redirect=true";
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    private void cargarMenu(List<Menuitems> litaMenuItems) {
        this.setDefaultMenuModel(new DefaultMenuModel());
        try {
            for (Menuitems menu : litaMenuItems) {
                if (menu.getIdPadre() != null && menu.getIdPadre().equals(Long.valueOf(0))) {
                    DefaultSubMenu subMenu = new DefaultSubMenu();
                    subMenu.setLabel(menu.getDescripcion());
                    this.cargarItems(menu, litaMenuItems, subMenu, null);
                    this.getDefaultMenuModel().getElements().add(subMenu);
                }
            }
        } catch (Exception e) {
        }
    }

    private MenuItem cargarItems(Menuitems men, List<Menuitems> listaMenu, DefaultSubMenu subMenu, MenuItem menuItem) {
        try {
            for (Menuitems menu : listaMenu) {
                if (menu.getIdPadre() != null) {
                    if (men.getId().longValue() == menu.getIdPadre().longValue()) {
                        if (menu.getOrden() != null) {
                            DefaultMenuItem menuItemFinal = new DefaultMenuItem();
                            menuItemFinal.setValue(menu.getDescripcion());
                            menuItemFinal.setUrl(FACES + menu.getUrl());
                            subMenu.addElement(menuItemFinal);
                        } else {
                            DefaultSubMenu subMenuHijo = new DefaultSubMenu();
                            subMenuHijo.setLabel(menu.getDescripcion());
                            subMenu.addElement(subMenuHijo);
                            MenuItem menus = this.cargarItems(menu, listaMenu, subMenuHijo, menuItem);
                            if (menus != null) {
                                subMenuHijo.addElement(menus);
                            }
                        }
                    }
                }
            }
            return menuItem;
        } catch (Exception e) {
            Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, "ERROR: " + e);
            return null;
        }
    }

    private void adminMenu() {
        try {
            List<Menuitems> listadoMenuItems = new ArrayList<Menuitems>();
            UsuariosRoles usuariosRoles = usuariosRolesDao.usuarioRolesXUsuario(usuario);
            List<UsuarioMenu> listaUsuarioMenu = this.usuarioMenuDao.listarUsuarioMenu(usuario);
            if (listaUsuarioMenu != null && !listaUsuarioMenu.isEmpty()) {
                for (UsuarioMenu um : listaUsuarioMenu) {
                    this.adminAcceso(um.getMenu(), listadoMenuItems);
                }
            }
            List<UserRolMenu> listaUserRolMenu = this.userRolMenuDao.listarUsuarioRolMenuXRol(usuariosRoles);
            if (listaUserRolMenu != null && !listaUserRolMenu.isEmpty()) {
                for (UserRolMenu urm : listaUserRolMenu) {
                    this.adminAcceso(urm.getMenu(), listadoMenuItems);
                }
            }
            Collections.reverse(listadoMenuItems);
            this.ordenarDupliocadosMenu(listadoMenuItems);
            this.ordenarMenuItem(listadoMenuItems);
            this.cargarMenu(this.getAuxListMenu());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adminAcceso(Menuitems menuItems, List<Menuitems> listaMenuItem) {
        try {
            listaMenuItem.add(menuItems);
            Menuitems menu = menuItemsDao.menuItemXId(menuItems);
            if (menu != null && !menu.getId().equals(Long.valueOf(0))) {
                this.adminAcceso(menu, listaMenuItem);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void ordenarDupliocadosMenu(List<Menuitems> listaMenuItems) {
        List<Menuitems> listaMenuItemsAux = new ArrayList<Menuitems>();
        for (Menuitems mi : listaMenuItems) {
            if (mi.getIdPadre().equals(Long.valueOf(0)) && !comprobarMenu(listaMenuItemsAux, mi)) {
                listaMenuItemsAux.add(mi);
            }
            for (Menuitems itemsMenu : listaMenuItems) {
                if (itemsMenu.getIdPadre().equals(mi.getId()) && !comprobarMenu(listaMenuItemsAux, itemsMenu)) {
                    listaMenuItemsAux.add(itemsMenu);
                }
            }
        }
        Collections.reverse(listaMenuItemsAux);
    }

    private void ordenarMenuItem(List<Menuitems> listaMenuItems) {
        try {
            for (Menuitems m1 : listaMenuItems) {
                for (Menuitems m2 : listaMenuItems) {
                    if (m1.getId() < m2.getId() && m1.getIdPadre().equals(Long.valueOf(0)) && m2.getIdPadre().equals(Long.valueOf(0)) && !comprobarMenu(auxListMenu, m1)) {
                        auxListMenu.add(m1);
                        this.ordenarSubMenuItems(m1, listaMenuItems, auxListMenu);
                    }
                    if (m1.getId() > m2.getId() && m1.getIdPadre().equals(Long.valueOf(0)) && m2.getIdPadre().equals(Long.valueOf(0)) && !comprobarMenu(auxListMenu, m1)) {
                        auxListMenu.add(m1);
                        this.ordenarSubMenuItems(m1, listaMenuItems, auxListMenu);
                    }
                }
            }

        } catch (Exception e) {
        }
    }

    private void ordenarSubMenuItems(Menuitems menuItems, List<Menuitems> menuItemsPrincipal, List<Menuitems> menuItemsAux) {
        try {
            for (Menuitems mp : menuItemsPrincipal) {
                if (mp.getIdPadre().equals(menuItems.getId()) && !comprobarMenu(menuItemsAux, mp)) {
                    menuItemsAux.add(mp);
                    this.ordenarSubMenuItems(mp, menuItemsPrincipal, menuItemsAux);
                }
            }
        } catch (Exception e) {
        }
    }

    private Boolean comprobarMenu(List<Menuitems> listaMenuItems, Menuitems menu) {
        if (listaMenuItems != null && !listaMenuItems.isEmpty()) {
            for (Menuitems m : listaMenuItems) {
                if (!m.getId().equals(Long.valueOf(0)) && m.getId().equals(menu.getId()) && m.getIdPadre().equals(menu.getIdPadre())) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public void cerrarSesion() {
        try {
            closeSession();
        } catch (Exception e) {
            error(getClass().getName(), "no se puede cerrar sesion", e);
        }
    }

    public List<Menuitems> getAuxListMenu() {
        return auxListMenu;
    }

    public void setAuxListMenu(List<Menuitems> auxListMenu) {
        this.auxListMenu = auxListMenu;
    }

    public List<Menuitems> getUserRolmenuItemsTmp() {
        return userRolmenuItemsTmp;
    }

    public void setUserRolmenuItemsTmp(List<Menuitems> userRolmenuItemsTmp) {
        this.userRolmenuItemsTmp = userRolmenuItemsTmp;
    }

    public List<Menuitems> getUserMenuItemsTmp() {
        return UserMenuItemsTmp;
    }

    public void setUserMenuItemsTmp(List<Menuitems> UserMenuItemsTmp) {
        this.UserMenuItemsTmp = UserMenuItemsTmp;
    }

    public Long getValidMenu() {
        return validMenu;
    }

    public void setValidMenu(Long validMenu) {
        this.validMenu = validMenu;
    }

    public Long getTotalNodos() {
        return totalNodos;
    }

    public void setTotalNodos(Long totalNodos) {
        this.totalNodos = totalNodos;
    }

    public MenuModel getDefaultMenuModel() {
        return defaultMenuModel;
    }

    public void setDefaultMenuModel(DefaultMenuModel defaulktMenuModel) {
        this.defaultMenuModel = defaulktMenuModel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public HttpSession getSessionIniciada() {
        return sessionIniciada;
    }

    public void setSessionIniciada(HttpSession sessionIniciada) {
        this.sessionIniciada = sessionIniciada;
    }
}