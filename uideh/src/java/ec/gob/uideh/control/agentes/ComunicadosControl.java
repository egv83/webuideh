/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.ComunicadosDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.agentes.entidades.Agente;
import ec.gob.uideh.agentes.entidades.Comunicados;
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

public class ComunicadosControl extends Comun implements Serializable{
    
    @EJB
    private ComunicadosDao comunicadosDao;
    @EJB
    private ParametroDao parametrosDao;
    
    private Comunicados comunicados; //Objeto tipo Comunicados
    
    private Long idtipocomunicado;//Variable del combo
    
    public ComunicadosControl(){
    }
    
    @PostConstruct
      private void inicio(){
          //this.comunicados = new Comunicados();
      }
    
      public List<Comunicados> getListComunicados()
      {
          try{
            return comunicadosDao.listacomunicados();
        }catch(Exception e){
            Logger.getLogger(ComunicadosControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
      }
      
      public List<SelectItem> getListaTipoDocumento(){
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametrosDao.listarParametros(DOCUMENTO)){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }
         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
      
      public void nuevo(){
          this.setComunicados(new Comunicados());
      }
      
     public void grabar(){
                 
        Parametros tipodocumento = new Parametros(this.getDocumento());
        this.getComunicados().setIdTipoComunicado(tipodocumento);
        
        this.comunicadosDao = new ComunicadosDao();
        this.comunicadosDao.ingresar(this.getComunicados());
         
         ponerMensajeInfo("SE GRABO");
     } 
     
    public Comunicados getComunicados() {
        return comunicados;
    }

    public void setComunicados(Comunicados comunicados) {
        this.comunicados = comunicados;
    }

    public Long getIdtipocomunicado() {
        return idtipocomunicado;
    }

    public void setIdtipocomunicado(Long idtipocomunicado) {
        this.idtipocomunicado = idtipocomunicado;
    }
      
     public Long getDocumento(){
        return DOCUMENTO;
    }  
}
