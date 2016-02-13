/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.DependientesDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.agentes.entidades.Dependiente;
import ec.gob.uideh.agentes.entidades.Parametros;
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
public class DependienteControl extends Comun implements Serializable{
    
    @EJB
    private DependientesDao dependienteDao;
    @EJB
    private ParametroDao parametroDao;
    
    private Dependiente dependiente; //Objeto tipo Dependiente
    
    private Long idparentesco; //Variable del combo
    private List<Dependiente> listaDependiente = new ArrayList<Dependiente>();
    
    public DependienteControl() {
        this.dependiente = new Dependiente();
    }
    
    @PostConstruct
    private void inicio(){
        
    }
    
    public List<Dependiente> getListadoDependiente(){
        try{
            return dependienteDao.listaDependiente();
        }catch(Exception e){
            Logger.getLogger(DependienteControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public List<SelectItem> getListParentesco(){   
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametroDao.listarParametros(PARENTESCO)){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }
         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
    
    public void nuevo(){
        this.setDependiente(new Dependiente());
    }
    
    public void grabar(){
        
        Parametros tipodependiente = new Parametros(this.getIdparentesco());
        this.getDependiente().setIdParentesco(tipodependiente);
        
        this.dependienteDao = new DependientesDao();
        this.dependienteDao.ingresar(this.getDependiente());

        ponerMensajeInfo("SE GRABO");
    }
    
    public void agregarDependiente(Dependiente dependiente){
        this.getListaDependiente().add(dependiente);
    }
    
    public List<Dependiente> getListaDependiente() {
        return listaDependiente;
    }

    public void setListaDependiente(List<Dependiente> listaDependiente) {
        this.listaDependiente = listaDependiente;
    }

    public Dependiente getDependiente() {
        return dependiente;
    }

    public void setDependiente(Dependiente Dependiente) {
        this.dependiente = Dependiente;
    }
    
    public Long getParentesco(){
        return PARENTESCO;
    }

    public Long getIdparentesco() {
        return idparentesco;
    }

    public void setIdparentesco(Long idparentesco) {
        this.idparentesco = idparentesco;
    }
}
