/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.vehiculos;

import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.dao.vehiculos.VehiculosDao;
import ec.gob.uideh.vehiculos.entidades.Vehiculo;
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
public class VehiculoControl extends Comun implements Serializable{
    @EJB
    private ParametroDao parametroDao;
    @EJB
    private VehiculosDao vehiculosDao;
    
    private Vehiculo vehiculo;
    
    private String codigoVehiculo;
    private String placa;
    private String motor;
    private String chasis;
    private String marca;
    private String tipo;
    private String color;
    private String unidadServicio;
    private Long modelo;
    private Long cilindraje;
    private Long anio;
    private Long estado;
    
    public VehiculoControl(VehiculosDao vehiculosdao,ParametroDao parametrosDao,String codigoVehiculo,
        String  placa,
        String motor,
        String chasis,
        String  marca,
        String  tipo,
        String  color,
        String  unidadServicio,
        Long modelo,
        Long cilindraje,
        Long anio,
        Long estado){
        
        this.parametroDao = parametrosDao;
        this.vehiculosDao = vehiculosdao;
        this.codigoVehiculo = codigoVehiculo;
        this.placa = placa;
        this.motor = motor;
        this.chasis= chasis;
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.unidadServicio = unidadServicio;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.anio = anio;
        this.estado = estado;
    }
    
    public VehiculoControl(){
        this.vehiculo = new Vehiculo();
    }
    
     public List<Vehiculo> getListadoAgentes() {
        try {
            return vehiculosDao.listaAgentes();
        } catch (Exception e) {
            Logger.getLogger(VehiculoControl.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public List<SelectItem> getListParametros(Long tipoParam) {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        try {
            for (Parametros par : this.parametroDao.listarParametros(tipoParam)) {
                lista.add(new SelectItem(par.getId(), par.getParametro()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void nuevo() {
        this.setVehiculo(new Vehiculo());
    }
    
     public void grabar() {
         try {
             
         } catch (Exception e) {
             
            Parametros modelo = new Parametros(this.getModelo());
            this.getVehiculo().setModeloId(modelo);
            
            Parametros cilindraje = new Parametros(this.getCilindraje());
            this.getVehiculo().setCilindrajeId(cilindraje);

            Parametros estado = new Parametros(this.getEstado());
            this.getVehiculo().setEstadoId(estado);
            
             this.vehiculosDao.ingresar(this.getVehiculo());
         }
        
        
    }
     
     
    public ParametroDao getParametroDao() {
        return parametroDao;
    }

    public void setParametroDao(ParametroDao parametroDao) {
        this.parametroDao = parametroDao;
    }

    public VehiculosDao getVehiculosDao() {
        return vehiculosDao;
    }

    public void setVehiculosDao(VehiculosDao vehiculosDao) {
        this.vehiculosDao = vehiculosDao;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUnidadServicio() {
        return unidadServicio;
    }

    public void setUnidadServicio(String unidadServicio) {
        this.unidadServicio = unidadServicio;
    }

    public Long getModelo() {
        return modelo;
    }

    public void setModelo(Long modelo) {
        this.modelo = modelo;
    }

    public Long getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Long cilindraje) {
        this.cilindraje = cilindraje;
    }


    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public static Long getMODELO_VEHICULO() {
        return MODELO_VEHICULO;
    }

    public static Long getCILINDRAJE_VEHICULO() {
        return CILINDRAJE_VEHICULO;
    }

    public static Long getESTADO_VEHICULO() {
        return ESTADO_VEHICULO;
    }
    
    
}
