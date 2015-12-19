/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.dao.agentes.PermisoDao;
import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.agentes.entidades.Permisos;
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

/**
 *
 * @author Pablo
 */

@ManagedBean
@SessionScoped

public class PermisoControl extends Comun implements Serializable{
    @EJB
    private PermisoDao permisoDao;
    @EJB
    private ParametroDao parametrosDao;
    
    private Permisos permisos; //Objeto Tipo Permisos
    
    private Long idtipopermiso; //variable del combo
    
    public PermisoControl(){
    }
    
     @PostConstruct
    private void inicio(){
        
    }
    
    public List<Permisos> getListadoPermisos(){
        try{
            return permisoDao.listaPermisos();
        }catch(Exception e){
            Logger.getLogger(PermisoControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public List<SelectItem> getListParametros(){
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametrosDao.listarParametros(this.getTipoPermiso())){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }
         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
    
    public void nuevo(){
        this.setPermisos(new Permisos());
    }
    
    public void grabar(){
    
       Parametros tipoPermiso = new Parametros(this.getIdtipopermiso());
       this.getPermisos().setIdTipoPermiso(tipoPermiso);
       
       this.permisoDao = new PermisoDao();
       this.permisoDao.ingresar(this.getPermisos());
       
       ponerMensajeInfo("SE GRABO");
    
    }
//get y set

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public Long getIdtipopermiso() {
        return idtipopermiso;
    }

    public void setIdtipopermiso(Long idtipopermiso) {
        this.idtipopermiso = idtipopermiso;
    }
    
    public Long getTipoPermiso(){
        return TIPOPERMISO;
    }
    
}
