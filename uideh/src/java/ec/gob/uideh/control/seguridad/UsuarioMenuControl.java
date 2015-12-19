/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.seguridad;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.seguridad.UsuarioMenuDao;
import ec.gob.uideh.menu.entidades.Menuitems;
import ec.gob.uideh.menu.entidades.UsuarioMenu;
import ec.gob.uideh.menu.entidades.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sistemas
 */
@ManagedBean
@SessionScoped
public class UsuarioMenuControl extends Comun implements Serializable{

    @EJB
    private UsuarioMenuDao usuarioMenuDao;
    
    private Long idMenu;
    private Usuarios usuario;
    private Boolean opcionNuevo;
    private String userNombres;
    private String userApellido;
    private UsuarioMenu usuarioMenu;
    private List<UsuarioMenu> listaUsuarioMenu;
    
    public UsuarioMenuControl() {
    }
    
    @PostConstruct
    private void inicio(){
        this.llenarListaMenuUsuario();
    }
    
    private void llenarListaMenuUsuario(){
        this.setListaUsuarioMenu(new ArrayList<UsuarioMenu>());
        try{
            this.setListaUsuarioMenu(this.usuarioMenuDao.listarUsuarioMenu());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Boolean getOpcionNuevo() {
        return opcionNuevo;
    }

    public void setOpcionNuevo(Boolean opcionNuevo) {
        this.opcionNuevo = opcionNuevo;
    }
    
    private void limpiar()
    {
        this.setUsuario(new Usuarios());
        this.setIdMenu(null);
        this.setUserNombres(null);
        this.setUserApellido(null);
    }
   
    public void nuevo(){
        this.setOpcionNuevo(Boolean.TRUE);
        this.limpiar();
    }
    public void asignarSeleccionado(SelectEvent event){
        this.setUserNombres(this.getUsuario().getNombres());
        this.setUserApellido(this.getUsuario().getApellidos());
    }
    public void grabar(){
        UsuarioMenu usuarioMenus = new UsuarioMenu();
        Menuitems menuitems = new Menuitems(this.getIdMenu());
        try{
            usuarioMenus.setMenu(menuitems);
            usuarioMenus.setUsuario(this.getUsuario());
            this.usuarioMenuDao.crear(usuarioMenus);
            execute("PF('menuUsuarioDialog').hide();");
            this.llenarListaMenuUsuario();
            ponerMensajeInfo("LA ASIGNACION DEL MENÚ AL USUARIO FUE GUARDADA");
        }catch(Exception e){
            e.printStackTrace();
            ponerMensajeAlerta("NO SE GRABO LA ASIGNACION DEL MENÚ AL USUARIO");
        }
    }
    
    public void editar(SelectEvent event){
        this.setUserNombres(this.getUsuarioMenu().getUsuario().getNombres());
        this.setUserApellido(this.getUsuarioMenu().getUsuario().getApellidos());
        this.setIdMenu(this.getUsuarioMenu().getMenu().getId());
        this.setUsuario(this.getUsuarioMenu().getUsuario());
        this.setOpcionNuevo(Boolean.FALSE);
    }
    
    public void actualizar(){
        UsuarioMenu usuarioMenus = this.getUsuarioMenu();
        Menuitems menuitems = new Menuitems(this.getIdMenu());
        try{
            usuarioMenus.setMenu(menuitems);
            usuarioMenus.setUsuario(this.getUsuario());
            usuarioMenuDao.modificar(usuarioMenus);
            execute("PF('menuUsuarioDialog').hide();");
            this.llenarListaMenuUsuario();
            ponerMensajeInfo("LA ASIGNACION DEL MENÚ AL USUARIO FUE ACTUALIZADA");
        }catch(Exception e){
            e.printStackTrace();
            ponerMensajeAlerta("NO SE ACTUALIZO LOS DATOS");
        }
    }

    public void eliminar(){
        try{
           usuarioMenuDao.eliminar(this.getUsuarioMenu());
           execute("PF('menuUsuarioDialog').hide();");
           this.llenarListaMenuUsuario();
            ponerMensajeInfo("EL REGISTRO FUE BORRADO");
        }catch(Exception e){
            e.printStackTrace();
            ponerMensajeAlerta("NO SE PUDO BORRAR EL REGISTRO");
        }
    }
    
    public UsuarioMenu getUsuarioMenu() {
        return usuarioMenu;
    }

    public void setUsuarioMenu(UsuarioMenu usuarioMenu) {
        this.usuarioMenu = usuarioMenu;
    }

    public String getUserNombres() {
        return userNombres;
    }

    public void setUserNombres(String userNombres) {
        this.userNombres = userNombres;
    }

    public String getUserApellido() {
        return userApellido;
    }

    public void setUserApellido(String userApellido) {
        this.userApellido = userApellido;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public List<UsuarioMenu> getListaUsuarioMenu() {
        return listaUsuarioMenu;
    }

    public void setListaUsuarioMenu(List<UsuarioMenu> listaUsuarioMenu) {
        this.listaUsuarioMenu = listaUsuarioMenu;
    }
    
    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }
}