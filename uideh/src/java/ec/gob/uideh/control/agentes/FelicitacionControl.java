/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.FelicitacionDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.agentes.entidades.Agente;
import ec.gob.uideh.agentes.entidades.Felicitaciones;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pablo
 */

@ManagedBean
@SessionScoped

public class FelicitacionControl extends Comun implements Serializable{
    @EJB
    private FelicitacionDao felicitacionDao;
    /*@EJB
    private ParametroDao parametroDao;*/
    
    private Felicitaciones felicitaciones;//objeto tipo felicitaciones

    public FelicitacionControl(){
    }
    
    @PostConstruct
    private void inicio(){
    //this.felicitaciones = new Felicitaciones();
    }
    
    public List<Felicitaciones> getListFelicitaciones()
    {
        try{
            return felicitacionDao.listaFelicitaciones();
        }catch(Exception e){
            Logger.getLogger(CursosControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public void nuevo(){
        this.setFelicitaciones(new Felicitaciones());
    }
    
    public void grabar(Long agente)
    {
        
        //this.getFelicitaciones().setIdAgente(new Agente(agente));
        this.felicitacionDao = new FelicitacionDao();
        this.felicitacionDao.ingresar(this.getFelicitaciones());
        
        ponerMensajeInfo("SE GRABO");
    }  
    
     public Felicitaciones getFelicitaciones() {
        return felicitaciones;
    }

    public void setFelicitaciones(Felicitaciones felicitaciones) {
        this.felicitaciones = felicitaciones;
    }
}
