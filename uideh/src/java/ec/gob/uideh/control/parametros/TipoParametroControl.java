/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.parametros;

import ec.gob.uideh.dao.parametros.TipoParametroDao;
import ec.gob.uideh.agentes.entidades.TipoParametro;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pablo
 */
@ManagedBean
@SessionScoped
public class TipoParametroControl implements Serializable{
    @EJB
    private TipoParametroDao tipoParametroDao;
    
    private TipoParametro tipoParametro;
    private String tipoparametro;
    
    public TipoParametroControl(){
        this.tipoParametro = new TipoParametro();
    } 
    
    
    public List<TipoParametro> getListTipoParametro(){
        try{
            return tipoParametroDao.listTipoParametro();
        }catch(Exception e){
            Logger.getLogger(TipoParametroControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public void nuevo(){
        this.setTipoParametro(new TipoParametro());
        System.out.println("Entro en nuevo");
    }

      
    public void grabar(){
        System.out.println("Tipo Parametro valor: "+this.getTipoParametro());
        this.tipoParametroDao.ingresar(this.getTipoParametro());
        //this.getListadoAgentes();
       // ponerMensajeInfo("SE GRABO");
    }

     public TipoParametro getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(TipoParametro tipoParametro) {
        this.tipoParametro = tipoParametro;
    }
    
}
