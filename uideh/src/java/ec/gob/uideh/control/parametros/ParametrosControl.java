/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.parametros;

import ec.gob.uideh.control.agentes.AgenteControl;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.dao.parametros.TipoParametroDao;
import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.agentes.entidades.TipoParametro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ParametrosControl implements Serializable{
  
    @EJB
    private ParametroDao parametroDao;
    @EJB
    private TipoParametroDao tipoparametroDao;
    
    private Parametros parametros;
    private String parametro;
    private Long idTipoParametro;
            
    public ParametrosControl(){
        this.parametros = new Parametros();
    }
    
    public List<Parametros> getListaParametros(){
        try {
            return parametroDao.listparametros();
        } catch (Exception e) {
            Logger.getLogger(AgenteControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public  List<SelectItem> getListTipoParametro(){
        List<SelectItem> lista = new ArrayList<SelectItem>();
        try {
            for (TipoParametro tipa : this.tipoparametroDao.listTipoParametro() ){
                lista.add(new SelectItem(tipa.getId(),tipa.getTipoParametro()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void nuevo(){
        this.setParametro(new String());
        this.setIdTipoParametro(new Long(0));
        
        System.out.println("Entro en nuevo");
    }
    
    public void grabar(){
        TipoParametro tipoParam = new TipoParametro(this.getIdTipoParametro());
        this.setParametros(new Parametros());
        this.getParametros().setIdTipoParametro(tipoParam);
        this.getParametros().setParametro(this.getParametro());
        this.parametroDao.ingresar(this.getParametros());    
    }
    
    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Long getIdTipoParametro() {
        return idTipoParametro;
    }

    public void setIdTipoParametro(Long idTipoParametro) {
        this.idTipoParametro = idTipoParametro;
    } 

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }
    
    
}
