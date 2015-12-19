/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.OperativoDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.agentes.entidades.Operativos;
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

public class OperativoControl extends Comun implements Serializable{
   
    @EJB
    private OperativoDao operativoDao;
    @EJB
    private ParametroDao parametrosDao;
    
    
    private Operativos operativos;//objeto tipo operativo
    
    private Long id_ciudad; //variable del combo
    
    public OperativoControl(){
    }
    
    @PostConstruct
    private void inicio(){
    }
    
    public List<Operativos> getListOperativos(){
        try{
            return operativoDao.listaOperativos();
        }catch(Exception e){
            Logger.getLogger(OperativoControl.class.getName()).log(Level.SEVERE,null,e);
        }
            return null;
        }
    
    public List<SelectItem> getListParametros(){
        List<SelectItem> lista = new ArrayList<SelectItem>();
        try {
            for(Parametros par: this.parametrosDao.listarParametros(this.getciudad())){
                lista.add(new SelectItem(par.getId(),par.getParametro()));
            }
        
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;        
    }

    public Long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    
    public Long getciudad(){
        return CIUDADPAIS;
    }
}
