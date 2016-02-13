/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.CuentaBancosDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.agentes.entidades.Agente;
import ec.gob.uideh.agentes.entidades.CuentaBancos;
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

public class BancoControl extends Comun  implements Serializable{
    
    @EJB
    private CuentaBancosDao cuentabancosDao;
    @EJB
    private ParametroDao parametrosDao;
    
    private CuentaBancos cuentabancos;//Objeto tipo Bancos
    
    private Long idtipocuenta;//Variable del combo
    private Long idnombrebanco;//Variable del combo
    
    public BancoControl(){
    }    
    
    @PostConstruct
    private void inicio(){
       // this.cuentabancos= new CuentaBancos();
    }
    
    public List<CuentaBancos> getListadoBancos(){
        try{
            return cuentabancosDao.listaCuentaBancos();
        }catch(Exception e){
            Logger.getLogger(BancoControl.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }

    public List<SelectItem> getListParametros(Long tipoParam){
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametrosDao.listarParametros(tipoParam)){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }

         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
    
    public List<SelectItem> getListaBancos(){
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametrosDao.listarParametros(NOMBREBANCO)){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }

         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
    
    public List<SelectItem> getListaTipoCuenta(){
         List<SelectItem> lista = new ArrayList<SelectItem>();
         try{
             for(Parametros par: this.parametrosDao.listarParametros(TIPOCUENTA)){
                 lista.add(new SelectItem(par.getId(), par.getParametro()));
             }

         }catch (Exception e){
             e.printStackTrace();
         }       
         return lista;
     }
    
    public void nuevo(){
        this.setCuentabancos(new CuentaBancos());
    }
    
    public void grabar(){

        //this.getCuentabancos().setIdAgente(new Agente(agente));
        
        Parametros nombrebanco = new Parametros(this.getIdnombrebanco());
        this.getCuentabancos().setIdNombrebanco(nombrebanco);
                
        Parametros tipocuenta = new Parametros(this.getIdtipocuenta());
        this.getCuentabancos().setIdTipocuenta(tipocuenta);
                
        this.cuentabancosDao = new CuentaBancosDao();
        this.cuentabancosDao.ingresar(this.getCuentabancos());

        ponerMensajeInfo("SE GRABO");
    }
    
    public CuentaBancos getCuentabancos() {
        return cuentabancos;
    }

    public void setCuentabancos(CuentaBancos cuentabancos) {
        this.cuentabancos = cuentabancos;
    }
    
    public Long getTipoCuenta(){
        return TIPOCUENTA;
    }
    
     public Long getNombreBanco(){
        return NOMBREBANCO;
    }

    public Long getIdtipocuenta() {
        return idtipocuenta;
    }

    public void setIdtipocuenta(Long idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
    }

    public Long getIdnombrebanco() {
        return idnombrebanco;
    }

    public void setIdnombrebanco(Long idnombrebanco) {
        this.idnombrebanco = idnombrebanco;
    }
    
    
}
