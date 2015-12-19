/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.seguridad;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.seguridad.MenuItemsDao;
import ec.gob.uideh.dao.seguridad.UserRolMenuDao;
import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.menu.entidades.Menuitems;
import ec.gob.uideh.menu.entidades.UserRolMenu;
import ec.gob.uideh.menu.entidades.UsuariosRoles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sistemas
 */
@ManagedBean
@SessionScoped
public class UserRolMenuControl extends Comun implements Serializable {

    @EJB
    private UserRolMenuDao userRolMenuDao;
    @EJB
    private MenuItemsDao menuItemsDao;

    private List<UserRolMenu> listaUserRolMenu;
    private List<UsuariosRoles> listaUserRol;
    private UserRolMenu userRolMenuSeleccionado;
    private Long idRol;
    private Long idMenu;
    private Boolean opNuevo;

    public UserRolMenuControl() {

    }

    @PostConstruct
    public void inicio() {
        this.llenarListaUserRolMenu();
    }

    private void llenarListaUserRolMenu() {
        this.setListaUserRolMenu(new ArrayList<UserRolMenu>());
        this.setListaUserRolMenu(userRolMenuDao.listarUserRolMenu());
    }

    public List<SelectItem> getListaMenuLink() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        try {
            for (Menuitems mi : menuItemsDao.listarMenusLink()) {
                lista.add(new SelectItem(mi.getId(), mi.getDescripcion()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public void nuevo() {
        this.setIdMenu(null);
        this.setIdRol(null);
        this.setUserRolMenuSeleccionado(null);
        this.setOpNuevo(Boolean.TRUE);
    }

    public void editar(SelectEvent event) {
        this.setIdMenu(this.getUserRolMenuSeleccionado().getMenu().getId());
        this.setIdRol(this.getUserRolMenuSeleccionado().getRol().getId());
        this.setOpNuevo(Boolean.FALSE);
    }   

    public void grabar() {
        try {
            if (this.getIdMenu() != null && this.getIdRol() != null) {
                Menuitems menuitems = new Menuitems(this.getIdMenu());
                Parametros rol = new Parametros(this.getIdRol());

                UserRolMenu userRolMenu = new UserRolMenu();
                userRolMenu.setMenu(menuitems);
                userRolMenu.setRol(rol);

                userRolMenuDao.crear(userRolMenu);
                this.llenarListaUserRolMenu();
                execute("PF('userRolMenuDialog').hide();");
                ponerMensajeInfo("SE GRABO EL MENU ASIGNADO AL ROL");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ponerMensajeAlerta("NO SE GRABO LOS DATOS: ");
        }
    }

    public void actualizar() {
        try {
            Menuitems menuitems = new Menuitems(this.getIdMenu());
            Parametros rol = new Parametros(this.getIdRol());

            UserRolMenu userRolMenu = new UserRolMenu();
            userRolMenu.setMenu(menuitems);
            userRolMenu.setRol(rol);
            userRolMenuDao.modificar(userRolMenu);
            this.llenarListaUserRolMenu();
            execute("PF('userRolMenuDialog').hide();");
            ponerMensajeInfo("SE ACTUALIZO EL MENU ASIGNADO AL ROL");
        } catch (Exception e) {
            e.printStackTrace();
            ponerMensajeAlerta("NO SE GRABO LOS DATOS");
        }
    }
    
    public void eliminar(){
        try{
            userRolMenuDao.eliminar(this.getUserRolMenuSeleccionado());
            this.llenarListaUserRolMenu();
            execute("PF('userRolMenuDialog').hide();");
            ponerMensajeInfo("EL DATO SELECCIONADO SE ELIMINO");
        }catch(Exception e){
            e.printStackTrace();
            ponerMensajeAlerta("NO SE PUDO ELIMINAR");
        }
    }

    public Boolean getOpNuevo() {
        return opNuevo;
    }

    public void setOpNuevo(Boolean opNuevo) {
        this.opNuevo = opNuevo;
    }

    public List<UsuariosRoles> getListaUserRol() {
        return listaUserRol;
    }

    public void setListaUserRol(List<UsuariosRoles> listaUserRol) {
        this.listaUserRol = listaUserRol;
    }

    public UserRolMenu getUserRolMenuSeleccionado() {
        return userRolMenuSeleccionado;
    }

    public void setUserRolMenuSeleccionado(UserRolMenu userRolMenuSeleccionado) {
        this.userRolMenuSeleccionado = userRolMenuSeleccionado;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public List<UserRolMenu> getListaUserRolMenu() {
        return listaUserRolMenu;
    }

    public void setListaUserRolMenu(List<UserRolMenu> listaUserRolMenu) {
        this.listaUserRolMenu = listaUserRolMenu;
    }
}