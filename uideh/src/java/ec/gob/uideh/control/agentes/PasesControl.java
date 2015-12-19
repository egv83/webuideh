/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.dao.agentes.PasesDao;
import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.agentes.entidades.Pases;
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

public class PasesControl  extends Comun  implements Serializable{
    @EJB
    private ParametroDao parametrosDao;
    @EJB
    private PasesDao pasesDao;
    
    private Pases pases;
    
    private Long idtipodocumentopase;//variable del combo
       
    public PasesControl(){
    }
    
    @PostConstruct
    private void inicio(){
    }
    
    public List<Pases> getListadoBancos(){
        try{
            return pasesDao.listaPases();
        }catch(Exception e){
            Logger.getLogger(BancoControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public List<SelectItem> getListParametros(){
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametrosDao.listarParametros(this.gettipodocumentopase())){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }

         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
    
    public void nuevo(){
        this.setPases(new Pases());
    }
    
    public void grabar(){
        
        Parametros tipodocumentopase = new Parametros(this.getIdtipodocumentopase());
        this.getPases().setIdTipoDocumento(tipodocumentopase);
                      
        this.pasesDao = new PasesDao();
        this.pasesDao.ingresar(this.getPases());
        
         ponerMensajeInfo("SE GRABO");
    }

    public Pases getPases() {
        return pases;
    }

    public void setPases(Pases pases) {
        this.pases = pases;
    }

    public Long getIdtipodocumentopase() {
        return idtipodocumentopase;
    }

    public void setIdtipodocumentopase(Long idtipodocumentopase) {
        this.idtipodocumentopase = idtipodocumentopase;
    }
    
    public Long gettipodocumentopase() {
        return DOCUMENTO;
    }
   
    
}
