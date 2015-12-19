/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.seguridad;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.seguridad.MenuItemsDao;
import ec.gob.uideh.menu.entidades.Menuitems;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Sistemas
 */
@ManagedBean
@SessionScoped
public class MenuItemControl extends Comun implements Serializable{

    @EJB
    MenuItemsDao menuItemsDao;
    private Menuitems seleccionMenuItems;
    private List<Menuitems> listaMenuItems;
    private TreeNode arbolMenu;
    private List<SelectItem> arbolMenuSelect;
    private Menuitems seleccionadoMenu;
    private Menuitems seleccionadoSubMenu;
    private List<SelectItem> listaMenu;
    private List<SelectItem> listaMenuPadre;
    private List<SelectItem> listaSubMenu;
    private List<SelectItem> listaMenuLink;
    private Boolean btNuevo;
    private Boolean btEdit;

    private Long orden;
    
    public MenuItemControl() {
        this.seleccionMenuItems=new Menuitems();
    }
    
    @PostConstruct
    public void inicio() {
        this.listaMenuItems = new ArrayList<Menuitems>();
        this.arbolMenuSelect = new ArrayList<SelectItem>();
        try {
            this.cargarListaMenu();
            this.refrescarArbolMenu();
        } catch (Exception ex) {
            Logger.getLogger(MenuItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refrescarArbolMenu() throws Exception{
        this.arbolMenu = this.crearArbolMenuItems(menuItemsDao.listarMenus());
    }

    private void cargarListaMenu() {
        try {
            this.setListaMenuItems(menuItemsDao.listarMenus());
            this.crearArbolMenuItems(menuItemsDao.listarMenus());
            this.llenarListaMenu();
        } catch (Exception e) {
            Logger.getLogger(Menuitems.class.getName()).log(Level.SEVERE, "ERROR: " + e);
        }
    }

    private TreeNode crearArbolMenuItems(List<Menuitems> litaMenuItems) {
        this.arbolMenu= new DefaultTreeNode();
        TreeNode root = new DefaultTreeNode(new Menuitems(Long.valueOf(0),Long.valueOf(0), "Label", "Url"));
        try {
            for (Menuitems menu : litaMenuItems) {
                if (menu.getIdPadre()!=null && menu.getIdPadre().equals(Long.valueOf(0))) {
                    TreeNode subMenu = new DefaultTreeNode(new Menuitems(menu.getId(),menu.getIdPadre(), menu.getDescripcion(), menu.getUrl()), root);
                    this.cargarItems(menu, litaMenuItems, subMenu, null);
                    this.arbolMenu = subMenu;
                }
            }
        } catch (Exception e) {
        }
        return root;
    }

    private TreeNode cargarItems(Menuitems men, List<Menuitems> listaMenu, TreeNode subMenu, TreeNode menuItem) {
        try {
            for (Menuitems menu : listaMenu) {
                if (menu.getIdPadre() != null) {
                    if (men.getId().longValue() == menu.getIdPadre().longValue()) {
                        if (menu.getOrden() != null) {
                            TreeNode menuItemFinal = new DefaultTreeNode(new Menuitems(menu.getId(),menu.getIdPadre(),menu.getDescripcion(),menu.getUrl()),subMenu);
                        } else {
                            TreeNode subMenuHijo = new DefaultTreeNode(new Menuitems(menu.getId(),menu.getIdPadre(),menu.getDescripcion(),menu.getUrl()),subMenu);
                            TreeNode menus = this.cargarItems(menu, listaMenu, subMenuHijo, menuItem);
                            if (menus != null) {
                                Menuitems menuAux=(Menuitems)menus;
                                TreeNode subMenuHijos=new DefaultTreeNode(new Menuitems(menu.getId(),menu.getIdPadre(),menu.getDescripcion(),menu.getUrl()),subMenuHijo);
                            }
                        }
                    }
                }
            }
            return menuItem;
        } catch (Exception e) {
            Logger.getLogger(MenuItemControl.class.getName()).log(Level.SEVERE, "ERROR: " + e);
            return null;
        }
    }

    private void llenarListaMenu(){
        this.listaMenuPadre = new ArrayList<SelectItem>();
        try{
            for(Menuitems menu:this.menuItemsDao.menuItemXIdPadres(new Menuitems(new Long(0)))){
                this.listaMenuPadre.add(new SelectItem(menu.getId(),menu.getDescripcion()));
            }
        }catch(Exception e){}
    }
    
    public void llenarListaSubMenu(Long idMenu){
        try{
            List<Menuitems> lista=this.menuItemsDao.menuItemXIdPadres(new Menuitems(idMenu));
            this.listaSubMenu= new ArrayList<SelectItem>();
            if(lista!=null && !lista.isEmpty()){
                for(Menuitems menu:lista){
                    if(menu.getOrden()==null){
                        this.listaSubMenu.add(new SelectItem(menu.getId(),menu.getDescripcion()));
                    }
                }
              }
        }catch(Exception e){}
    }
    
    public void llenarMenuLink(Long idMenu){
        Long id=new Long(0);
        try{
            if(idMenu!=null){
                id=idMenu;
            }
            List<Menuitems> lista=this.menuItemsDao.menuItemXIdPadres(new Menuitems(id));
            this.listaMenuLink=new ArrayList<SelectItem>();
            if(lista!=null && !lista.isEmpty()){
                for(Menuitems menu:lista){
                    if(menu.getOrden()!=null){
                        this.listaMenuLink.add(new SelectItem(menu.getId(),menu.getDescripcion()));
                    }
                }
            }
        }catch(Exception e){}
    }

    public void menuSeleccionado(Menuitems menu){
        try{
            this.setBtNuevo(Boolean.FALSE);
            this.setBtEdit(Boolean.TRUE);
            
            this.seleccionMenuItems=menu;
            this.llenarListaMenu();
            this.setOrden(menu.getOrden());            
        }catch(Exception e){}
    }
    
    public void nuevo(){
        this.setBtNuevo(Boolean.TRUE);
        this.setBtEdit(Boolean.FALSE);
        this.setOrden(null);
        this.setSeleccionMenuItems(new Menuitems());
        this.limpiar();
    }

    public void guardar(){
        Menuitems grabarMenu = new Menuitems();
        try{    
            if("".equals(this.getSeleccionMenuItems().getDescripcion()) || this.getSeleccionMenuItems().getDescripcion()== null ){
                ponerMensajeError(MENSAJE_MENU_ITEMS);
                execute("PF('menuItemDialog').jq.effect(\"shake\", {times: 5}, 100);");
            }
            else{

                if(this.getSeleccionMenuItems().getIdPadre()!=null && this.getSeleccionMenuItems().getIdPadre()!=Long.valueOf(0)){
                    grabarMenu.setIdPadre(this.getSeleccionMenuItems().getIdPadre());
                }
                if(this.getSeleccionMenuItems().getIdPadre()==null){
                    grabarMenu.setIdPadre(Long.valueOf(0));
                }
                if(this.getSeleccionMenuItems().getUrl()!=null && !"".equals(this.getSeleccionMenuItems().getUrl())){
                    grabarMenu.setOrden(Long.valueOf(1));
                }else{
                    grabarMenu.setOrden(null);
                }
                grabarMenu.setDescripcion(this.getSeleccionMenuItems().getDescripcion().toUpperCase());
                
                grabarMenu.setUrl(this.getSeleccionMenuItems().getUrl());
                this.menuItemsDao.crear(grabarMenu);
                
                this.limpiar();
                this.refrescarArbolMenu();
                this.llenarListaMenu();
                ponerMensajeInfo("MENU GUARDADO");
                execute("PF('menuItemDialog').hide();");
            }
        }catch(Exception e){}
    }
 
    public void actualizar(){
        Menuitems actualizar = new Menuitems();
        try{
            if(this.getSeleccionMenuItems().getIdPadre()==null)
            {
                actualizar.setIdPadre(Long.valueOf(0));
            }else{
                actualizar.setIdPadre(this.getSeleccionMenuItems().getIdPadre());
            }
            actualizar.setId(this.getSeleccionMenuItems().getId());
            actualizar.setDescripcion(this.getSeleccionMenuItems().getDescripcion().toUpperCase());
            actualizar.setUrl(this.getSeleccionMenuItems().getUrl());
            if(this.getSeleccionMenuItems().getOrden()!=null && !"".equals(this.getSeleccionMenuItems().getOrden().toString())){
                actualizar.setOrden(this.getSeleccionMenuItems().getOrden());
            }
            if(!"".equals(this.getSeleccionMenuItems().getUrl()) && this.getSeleccionMenuItems().getUrl()!=null){
                actualizar.setOrden(Long.valueOf(1));
            }else{
                actualizar.setOrden(null);
            }
            this.menuItemsDao.modificar(actualizar);
            
            this.limpiar();
            this.refrescarArbolMenu();
            this.llenarListaMenu();
            ponerMensajeInfo("MENU ACTUALIZADO");
            execute("PF('menuItemDialog').hide();");
        }catch(Exception e){}
    }
      
    public void eliminar(Menuitems menu){
        try{
            if(!this.menuItemsDao.buscarMenuHijo(menu))
            {
                this.menuItemsDao.eliminar(menu);
                this.refrescarArbolMenu();
                ponerMensajeInfo("EL MESÚ SELECCIONADO FUE BORRADO");
            }else{
                ponerMensajeAlerta(MENSAJE_ELIMINAR_MENU);
            }
        }catch(Exception e){}
    }
    
    private void limpiar(){
        this.setSeleccionMenuItems(new Menuitems());
    }
    
    public Boolean getBtNuevo() {
        return btNuevo;
    }

    public void setBtNuevo(Boolean btNuevo) {
        this.btNuevo = btNuevo;
    }

    public Boolean getBtEdit() {
        return btEdit;
    }

    public void setBtEdit(Boolean btEdit) {
        this.btEdit = btEdit;
    }

    public List<SelectItem> getArbolMenuSelect() {
        return arbolMenuSelect;
    }

    public void setArbolMenuSelect(List<SelectItem> arbolMenuSelect) {
        this.arbolMenuSelect = arbolMenuSelect;
    }
    
    public List<SelectItem> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<SelectItem> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public List<SelectItem> getListaMenuLink() {
        return listaMenuLink;
    }

    public void setListaMenuLink(List<SelectItem> listaMenuLink) {
        this.listaMenuLink = listaMenuLink;
    }

    public List<SelectItem> getListaMenuPadre() {
        return listaMenuPadre;
    }

    public void setListaMenuPadre(List<SelectItem> listaMenuPadre) {
        this.listaMenuPadre = listaMenuPadre;
    }
    
    public List<SelectItem> getListaSubMenu() {
        return listaSubMenu;
    }

    public void setListaSubMenu(List<SelectItem> listaSubMenu) {
        this.listaSubMenu = listaSubMenu;
    }

    public Menuitems getSeleccionadoMenu() {
        return seleccionadoMenu;
    }

    public void setSeleccionadoMenu(Menuitems seleccionadoMenu) {
        this.seleccionadoMenu = seleccionadoMenu;
    }

    public Menuitems getSeleccionadoSubMenu() {
        return seleccionadoSubMenu;
    }

    public void setSeleccionadoSubMenu(Menuitems seleccionadoSubMenu) {
        this.seleccionadoSubMenu = seleccionadoSubMenu;
    }

    public TreeNode getArbolMenu() {
        return arbolMenu;
    }

    public void setArbolMenu(TreeNode arbolMenu) {
        this.arbolMenu = arbolMenu;
    }

    public List<Menuitems> getListaMenuItems() {
        return listaMenuItems;
    }

    public void setListaMenuItems(List<Menuitems> listaMenuItems) {
        this.listaMenuItems = listaMenuItems;
    }

    public Menuitems getSeleccionMenuItems() {
        return seleccionMenuItems;
    }

    public void setSeleccionMenuItems(Menuitems seleccionMenuItems) {
        this.seleccionMenuItems = seleccionMenuItems;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }
}
