/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.agentes.entidades.Agente;
import ec.gob.uideh.agentes.entidades.Comunicados;
import ec.gob.uideh.agentes.entidades.CuentaBancos;
import ec.gob.uideh.agentes.entidades.Cursos;
import ec.gob.uideh.agentes.entidades.Dependiente;
import ec.gob.uideh.agentes.entidades.Felicitaciones;
import ec.gob.uideh.agentes.entidades.Operativos;
import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.agentes.entidades.Pases;
import ec.gob.uideh.agentes.entidades.Permisos;
import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.parametros.ParametroDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Esteban Vallejo
 */
@ManagedBean
//@ViewScoped
@SessionScoped
public class AgenteControl1 extends Comun implements Serializable {

    @EJB
    private ParametroDao parametroDao;

    private Agente agente;
    private Dependiente dependiente;
    private CuentaBancos cuentaBancos;
    private Comunicados comunicados;
    private Cursos cursos;
    private Felicitaciones felicitaciones;
    private Operativos operativos;
    private Pases pases;
    private Permisos permisos;
    private UploadedFile foto;
    private Long idTmp;

    private List<Dependiente> listaDependiente;
    private List<CuentaBancos> listaCuentaBancos;
    private List<Comunicados> listaComunicados;
    private List<Cursos> listaCursos;
    private List<Felicitaciones> listaFelicitaciones;
    private List<Operativos> listaOperativos;
    private List<Pases> listaPases;
    private List<Permisos> listaPermisos;

    /**
     * Creates a new instance of AgenteControl1
     */
    public AgenteControl1() {
        this.idTmp = new Long(0);
    }

    @PostConstruct
    private void inicio() {

        this.agente = new Agente();
        this.dependiente = new Dependiente();
        this.cuentaBancos = new CuentaBancos();
        this.comunicados = new Comunicados();
        this.cursos = new Cursos();
        this.felicitaciones = new Felicitaciones();
        this.operativos = new Operativos();
        this.pases = new Pases();
        this.permisos = new Permisos();
        this.listaDependiente = new ArrayList<Dependiente>();
        this.listaCuentaBancos = new ArrayList<CuentaBancos>();
        this.listaComunicados = new ArrayList<Comunicados>();
        this.listaCursos = new ArrayList<Cursos>();
        this.listaFelicitaciones = new ArrayList<Felicitaciones>();
        this.listaOperativos = new ArrayList<Operativos>();
        this.listaPases = new ArrayList<Pases>();       
        this.listaPermisos = new ArrayList<Permisos>();
    }

    public void grabar() {
        try {
            System.out.println("FECHA DE NACIEMIENTO: " + this.getAgente().getFechaNac());
            //this.uploadFile();

        } catch (Exception e) {
            ponerMensajeFatal("Error al registrar el agente " + e.getMessage());
        }
    }

    public List<SelectItem> getListaGrados() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(GRADO)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaGenero() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(SEXO)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaEstadoCivil() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(ESTADO_CIVIL)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaTipoSangre() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(SANGRE)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaNivelEducacion() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(NIVEL_EDUCACION)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaTituloUniversitario() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(TITULO)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaServicio() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(SERVICIO)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaAgencia() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(AGENCIA)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaDepartamento() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(DEPARTAMENTO)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List<SelectItem> getListaLicencia() {
        List<SelectItem> lista = new ArrayList<>();
        try {
            for (Parametros parametros : this.parametroDao.listarParametros(LICENCIA_CONDUCIR)) {
                lista.add(new SelectItem(parametros.getId(), parametros.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public void uploadFile() throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String str = this.getFoto().getFileName();
            String ext = str.substring(str.lastIndexOf('.'), str.length());
            this.getAgente().setFotoAgente(DESTINO_ARCHIVO + this.getAgente().getCedAgente() + ext);

            outputStream = new FileOutputStream(new File(this.getAgente().getFotoAgente()));
            inputStream = this.foto.getInputstream();

            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            ponerMensajeFatal("Por favor contacte con su administrador " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void agregarDependiente() {
        try {
            this.getDependiente().setIdDependiente(this.getIdTmp());
            this.getDependiente().setIdParentesco(parametroDao.obtenerParametroPorId(this.getDependiente().getIdParentesco()));
            this.getListaDependiente().add(this.getDependiente());
            this.setDependiente(new Dependiente());
            this.setIdTmp(this.getIdTmp() + 1);
        } catch (Exception e) {
            ponerMensajeFatal("Falla al agregar los dependientes");
        }
    }

    public void agregarCuentasBancos() {
        try {
            this.getCuentaBancos().setIdBanco(this.getIdTmp());
            this.getCuentaBancos().setIdNombrebanco(parametroDao.obtenerParametroPorId(this.getCuentaBancos().getIdNombrebanco()));
            this.getCuentaBancos().setIdTipocuenta(parametroDao.obtenerParametroPorId(this.getCuentaBancos().getIdTipocuenta()));
            this.getListaCuentaBancos().add(this.getCuentaBancos());
            this.setCuentaBancos(new CuentaBancos());
            this.setIdTmp(this.getIdTmp() + 1);
        } catch (Exception e) {
            ponerMensajeFatal("Falla al agregar las cuentas bancarias");
        }
    }

    public void agregarComunicados() {
        try {
            this.getComunicados().setIdComunicado(this.getIdTmp());
            this.getComunicados().setIdTipoComunicado(parametroDao.obtenerParametroPorId(this.getComunicados().getIdTipoComunicado()));
            this.getListaComunicados().add(this.getComunicados());
            this.setComunicados(new Comunicados());
            this.setIdTmp(this.getIdTmp() + 1);
        } catch (Exception e) {
            ponerMensajeFatal("Falla al agregar los comunicados");
        }
    }
    
    public void agregarCursos(){
        try{
            this.getCursos().setIdcurso(this.getIdTmp());
            this.getCursos().setIdTipoCurso(parametroDao.obtenerParametroPorId(this.getCursos().getIdTipoCurso()));
            this.getCursos().setIdLugarCurso(parametroDao.obtenerParametroPorId(this.getCursos().getIdLugarCurso()));
            this.getListaCursos().add(this.getCursos());
            this.setCursos(new Cursos());
            this.setIdTmp(this.getIdTmp() + 1);
        }catch(Exception e){
            ponerMensajeFatal("Falla al agregar los cursos");
        }
    }
    
    public void agregarFelicitaciones(){
        try{
            this.getFelicitaciones().setIdFelicitacion(this.getIdTmp());
            this.getListaFelicitaciones().add(this.getFelicitaciones());
            this.setFelicitaciones(new Felicitaciones());
            this.setIdTmp(this.getIdTmp()+1);
        }catch(Exception e){
            ponerMensajeFatal("Falla al agregar las felicitaciones");
        }
    }
    
    public void agregarOperativos(){
        try{
            this.getOperativos().setIdOperativo(this.getIdTmp());
            this.getOperativos().setIdCiudad(parametroDao.obtenerParametroPorId(this.getOperativos().getIdCiudad()));
            this.getListaOperativos().add(this.getOperativos());
            this.setOperativos(new Operativos());
            this.setIdTmp(this.getIdTmp()+1);
        }catch(Exception e){
            ponerMensajeFatal("Falla al agregar los operativos");
        }
    }
    
    public void agregarPases(){
        try{
            this.getPases().setIdPase(this.getIdTmp());
            this.getPases().setIdTipoDocumento(parametroDao.obtenerParametroPorId(this.getPases().getIdTipoDocumento()));
            this.getListaPases().add(this.getPases());
            this.setPases(new Pases());
            this.setIdTmp(this.getIdTmp()+1);
        }catch(Exception e){
            ponerMensajeFatal("Falla al agregar los pases");
        }
    }
    
    public void agregarPermisos(){
        try{
            this.getPermisos().setIdPermiso(this.getIdTmp());
            this.getPermisos().setIdTipoPermiso(parametroDao.obtenerParametroPorId(this.getPermisos().getIdTipoPermiso()));
            this.getListaPermisos().add(this.getPermisos());
            this.setPermisos(new Permisos());
            this.setIdTmp(this.getIdTmp()+1);
        }catch(Exception e){
            ponerMensajeFatal("Falla al agregar los pases");
        }
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public Dependiente getDependiente() {
        return dependiente;
    }

    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }

    public List<Dependiente> getListaDependiente() {
        return listaDependiente;
    }

    public void setListaDependiente(List<Dependiente> listaDependiente) {
        this.listaDependiente = listaDependiente;
    }

    public Long getIdTmp() {
        return idTmp;
    }

    public void setIdTmp(Long idTmp) {
        this.idTmp = idTmp;
    }

    public CuentaBancos getCuentaBancos() {
        return cuentaBancos;
    }

    public void setCuentaBancos(CuentaBancos cuentaBancos) {
        this.cuentaBancos = cuentaBancos;
    }

    public List<CuentaBancos> getListaCuentaBancos() {
        return listaCuentaBancos;
    }

    public void setListaCuentaBancos(List<CuentaBancos> listaCuentaBancos) {
        this.listaCuentaBancos = listaCuentaBancos;
    }

    public Comunicados getComunicados() {
        return comunicados;
    }

    public void setComunicados(Comunicados comunicados) {
        this.comunicados = comunicados;
    }

    public List<Comunicados> getListaComunicados() {
        return listaComunicados;
    }

    public void setListaComunicados(List<Comunicados> listaComunicados) {
        this.listaComunicados = listaComunicados;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public List<Cursos> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Felicitaciones getFelicitaciones() {
        return felicitaciones;
    }

    public void setFelicitaciones(Felicitaciones felicitaciones) {
        this.felicitaciones = felicitaciones;
    }

    public List<Felicitaciones> getListaFelicitaciones() {
        return listaFelicitaciones;
    }

    public void setListaFelicitaciones(List<Felicitaciones> listaFelicitaciones) {
        this.listaFelicitaciones = listaFelicitaciones;
    }

    public Operativos getOperativos() {
        return operativos;
    }

    public void setOperativos(Operativos operativos) {
        this.operativos = operativos;
    }

    public List<Operativos> getListaOperativos() {
        return listaOperativos;
    }

    public void setListaOperativos(List<Operativos> listaOperativos) {
        this.listaOperativos = listaOperativos;
    }

    public Pases getPases() {
        return pases;
    }

    public void setPases(Pases pases) {
        this.pases = pases;
    }

    public List<Pases> getListaPases() {
        return listaPases;
    }

    public void setListaPases(List<Pases> listaPases) {
        this.listaPases = listaPases;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public List<Permisos> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }
    
}
