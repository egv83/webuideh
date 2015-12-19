/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.agentes;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.dao.agentes.AgentesDao;
import ec.gob.uideh.dao.agentes.ComunicadosDao;
import ec.gob.uideh.dao.agentes.CuentaBancosDao;
import ec.gob.uideh.dao.agentes.CursosDao;
import ec.gob.uideh.dao.agentes.DependientesDao;
import ec.gob.uideh.dao.agentes.FelicitacionDao;
import ec.gob.uideh.dao.agentes.OperativoDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.dao.agentes.PasesDao;
import ec.gob.uideh.dao.agentes.PermisoDao;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.primefaces.model.UploadedFile;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author Pablo
 */
@ManagedBean
@SessionScoped
public class AgenteControl extends Comun implements Serializable {

    @EJB
    private AgentesDao agentesDao; //insertar
    @EJB
    private ParametroDao parametroDao;
    @EJB
    private DependientesDao dependientesDao;
    @EJB
    private CuentaBancosDao cuentabancosDao;
    @EJB
    private ComunicadosDao comunicadosDao;
    @EJB
    private CursosDao cursosDao;
    @EJB
    private FelicitacionDao felicitacionDao;
    @EJB
    private OperativoDao operativoDao;
    @EJB
    private PasesDao pasesDao;
    @EJB
    private PermisoDao permisoDao;
    
        
    private Dependiente dependiente;
    private CuentaBancos cuentaBancos;
    private Comunicados comunicados;
    private Cursos cursos;
    private Felicitaciones felicitaciones;
    private Operativos operativos;
    private Pases pases;
    private Permisos permisos;

  
    private Agente agente; //objeto tipo agente
    
    private String cedula; //variables de busqueda
    private String nombres; //variables de busqueda
    private String apellidos; //variables de busqueda
    private Long idGrado; //variable de combo 
    private Long idSexo;
    private Long idEstadoCivil;
    private Long idNivelEducacion;
    private Long idSangre;
    private Long idTitulo;
    private Long idServicio;
    private Long idAgencia;
    private Long idDepartamento;
    private Long idLicencia;
    private Long idEstado;
    private Long idAgentes;
    
    Long idDependienteTmp = new Long(0);
    Long idBancoTmp = new Long(0);
    Long idComunicadoTmp = new Long(0);
    Long idCursoTmp = new Long(0);
    Long idFelicitacionTmp = new Long(0);
    Long idOperativoTmp = new Long(0);
    Long idPaseTmp = new Long(0);
    Long idLicenciaTmp = new Long(0);
    
    UploadedFile file;
    private DefaultStreamedContent imagen;
    String rutaImagen;
    Boolean render;
   
    //lista de objetos 
    private List<Dependiente> listaDependientes;
    private List<CuentaBancos> listaBancos;
    private List<Comunicados> listaComunicados;
    private List<Cursos> listaCursos;
    private List<Felicitaciones> listaFelicitaciones;
    private List<Operativos> listaOperativos;
    private List<Pases> listaPases;
    private List<Permisos> listaLicencias;
    
//variable parentesco
    private Long idparentesco;
    // variable bancos
    private Long idnombrebanco;
    private Long idtipocuenta;
    //variable comunicados
    private Long idtipocomunicado;
    //variable cursos
    private Long idtipocurso;
    private Long idlugarcurso;
    //variable operativo
    private Long idciudad;
    //privtae pases
    private Long idtipodocumentopases;
    //variable Permisos
    private Long idtipopermiso;
    private Long idParametro; //Tipo parametro variable

    public AgenteControl(AgentesDao agentesDao, ParametroDao parametroDao, DependientesDao dependientesDao, CuentaBancosDao cuentabancosDao, ComunicadosDao comunicadosDao, CursosDao cursosDao, FelicitacionDao felicitacionDao, OperativoDao operativoDao, PasesDao pasesDao, PermisoDao permisoDao, Dependiente dependiente, CuentaBancos cuentaBancos, Comunicados comunicados, Cursos cursos, Felicitaciones felicitaciones, Operativos operativos, Pases pases, Permisos permisos, Agente agente, String cedula, String nombres, String apellidos, Long idGrado, Long idSexo, Long idEstadoCivil, Long idNivelEducacion, Long idSangre, Long idTitulo, Long idServicio, Long idAgencia, Long idDepartamento, Long idLicencia, Long idEstado, Long idAgentes, UploadedFile file, DefaultStreamedContent imagen, String rutaImagen, Boolean render, Long idparentesco, Long idnombrebanco, Long idtipocuenta, Long idtipocomunicado, Long idtipocurso, Long idlugarcurso, Long idciudad, Long idtipodocumentopases, Long idtipopermiso, Long idParametro) {
        this.agentesDao = agentesDao;
        this.parametroDao = parametroDao;
        this.dependientesDao = dependientesDao;
        this.cuentabancosDao = cuentabancosDao;
        this.comunicadosDao = comunicadosDao;
        this.cursosDao = cursosDao;
        this.felicitacionDao = felicitacionDao;
        this.operativoDao = operativoDao;
        this.pasesDao = pasesDao;
        this.permisoDao = permisoDao;
        this.dependiente = dependiente;
        this.cuentaBancos = cuentaBancos;
        this.comunicados = comunicados;
        this.cursos = cursos;
        this.felicitaciones = felicitaciones;
        this.operativos = operativos;
        this.pases = pases;
        this.permisos = permisos;
        this.agente = agente;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idGrado = idGrado;
        this.idSexo = idSexo;
        this.idEstadoCivil = idEstadoCivil;
        this.idNivelEducacion = idNivelEducacion;
        this.idSangre = idSangre;
        this.idTitulo = idTitulo;
        this.idServicio = idServicio;
        this.idAgencia = idAgencia;
        this.idDepartamento = idDepartamento;
        this.idLicencia = idLicencia;
        this.idEstado = idEstado;
        this.idAgentes = idAgentes;
        this.file = file;
        this.imagen = imagen;
        this.rutaImagen = rutaImagen;
        this.render = render;
        this.idparentesco = idparentesco;
        this.idnombrebanco = idnombrebanco;
        this.idtipocuenta = idtipocuenta;
        this.idtipocomunicado = idtipocomunicado;
        this.idtipocurso = idtipocurso;
        this.idlugarcurso = idlugarcurso;
        this.idciudad = idciudad;
        this.idtipodocumentopases = idtipodocumentopases;
        this.idtipopermiso = idtipopermiso;
        this.idParametro = idParametro;
    }

    public AgenteControl() {
        this.agente = new Agente();
        this.dependiente = new Dependiente();
        this.cuentaBancos = new CuentaBancos();
        this.comunicados = new Comunicados();
        this.cursos = new Cursos();
        this.felicitaciones = new Felicitaciones();
        this.operativos = new Operativos();
        this.pases = new Pases();
        this.permisos = new Permisos();
        this.listaDependientes = new ArrayList<Dependiente>();
        this.listaBancos = new ArrayList<CuentaBancos>();
        this.listaComunicados = new ArrayList<Comunicados>();
        this.listaCursos = new ArrayList<Cursos>();
        this.listaFelicitaciones = new ArrayList<Felicitaciones>();
        this.listaOperativos = new ArrayList<Operativos>();
        this.listaPases = new ArrayList<Pases>();
        this.listaLicencias = new ArrayList<Permisos>();
        
    }

    public List<Agente> getListadoAgentes() {
        try {
            return agentesDao.listaAgentes();
        } catch (Exception e) {
            Logger.getLogger(AgenteControl.class.getName()).log(Level.SEVERE, null, e);
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

    //lugar donde se guardara archivo de foto
    public void upload(FileUploadEvent event) {
        this.file = event.getFile();
        // Do what you want with the file 
        //EN EL PARAMETRO QUE SE ENVIA this.getFileName cambiar por el campo que se requiere para que el archivo se guarde con ese nombre
        //ejemplo si quiero que se guarde con el nombre del usuario que guardo se tiene que setear this.getNombres 
        try {
            //FacesMessage msg = new FacesMessage(copyFile(this.getFile().getFileName(), this.getFile().getInputstream()) + " " + this.getFile().getFileName() + " " + tamanos(this.getFile().getSize()));
            //FacesContext.getCurrentInstance().addMessage(null, msg);

            copyFile(this.getFile().getFileName(), this.getFile().getInputstream());

            this.setRutaImagen(DESTINO_ARCHIVO + this.getFile().getFileName());
            System.out.println("IMAGEN: " + this.getRutaImagen());
            this.cargarImagen(this.getRutaImagen());
            //imagenglobal = this.getRutaImagen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarImagen(String rutaImagen) throws FileNotFoundException {
        //FileInputStream fileInputStream = new FileInputStream("C:\\temp\\Desert.jpg");
        FileInputStream fileInputStream = new FileInputStream(rutaImagen);
        //this.setImagen(new DefaultStreamedContent(fileInputStream  , "image/jpg", "Desert.jpg"));
        this.setImagen(new DefaultStreamedContent(fileInputStream, "image/jpg"));

    }

    public void nuevo() {
        this.setAgente(new Agente());
    }

    public void grabar() {
        try {

            Parametros grado = new Parametros(this.getIdGrado());
            this.getAgente().setIdGrado(grado);
            
            Parametros sexo = new Parametros(this.getIdSexo());
            this.getAgente().setIdSexo(sexo);
            
            Parametros estadocivil = new Parametros(this.getIdEstadoCivil());
            this.getAgente().setIdEstacivil(estadocivil);

            Parametros sangre = new Parametros(this.getIdSangre());
            this.getAgente().setIdTiposangre(sangre);

            Parametros educacion = new Parametros(this.getIdNivelEducacion());
            this.getAgente().setIdNiveleduc(educacion);

            Parametros titulo = new Parametros(this.getIdTitulo());
            this.getAgente().setIdTituloUniv(titulo);

            Parametros servicio = new Parametros(this.getIdServicio());
            this.getAgente().setIdServicio(servicio);

            Parametros departamento = new Parametros(this.getIdDepartamento());
            this.getAgente().setIdDepartamento(departamento);

            Parametros licencia = new Parametros(this.getIdLicencia());
            this.getAgente().setIdLicenCond(licencia);

            Parametros estado = new Parametros(this.getIdEstado());
            this.getAgente().setStatusAgente(estado);

            Parametros agencia = new Parametros(this.getIdAgencia());
            this.getAgente().setIdAgencia(agencia);

            this.getAgente().setFotoAgente(this.getRutaImagen());

            /*ponerMensajeInfo("RUTA DE IMAGEN: "+this.getRutaImagen());
            ponerMensajeInfo("NOMBRES: "+this.getAgente().getNomAgente());
            ponerMensajeInfo("APELLIDOS: "+this.getAgente().getApellAgente());*/
            
            this.agentesDao.ingresar(this.getAgente());

            // GRABAR DEPENDIENTES//
            //this.getDependiente().setIdAgente(this.getAgente());
            //this.getDependiente().setIdParentesco(new Parametros(this.getIdparentesco()));  
            this.listaDependientes.add(getDependiente());
            this.dependientesDao.ingresar(this.getDependiente());
            
            // GRABAR BANCO //
            this.getCuentaBancos().setIdAgente(this.getAgente());
            this.getCuentaBancos().setIdNombrebanco(new Parametros(this.getIdnombrebanco()));
            this.getCuentaBancos().setIdTipocuenta(new Parametros(this.getIdtipocuenta()));
            this.cuentabancosDao.ingresar(this.getCuentaBancos());
            
            // GRABAR COMUNICADOS//
            this.getComunicados().setIdAgente(this.getAgente());
            this.getComunicados().setIdTipoComunicado(new Parametros(this.getIdtipocomunicado()));
            this.comunicadosDao.ingresar(this.getComunicados());
            
            // GRABAR CURSOS//
            this.getCursos().setIdAgente(this.getAgente());
            this.getCursos().setIdTipoCurso(new Parametros(this.getIdtipocurso()));
            this.getCursos().setIdLugarCurso(new Parametros(this.getIdlugarcurso()));
            this.cursosDao.ingresar(this.getCursos());
            
            //FELICITACIONES
            this.getFelicitaciones().setIdAgente(this.getAgente());
            this.felicitacionDao.ingresar(this.getFelicitaciones());
            
            //OPERATIVOS
            this.getOperativos().setIdAgente(this.getAgente());
            this.getOperativos().setIdCiudad(new Parametros(this.idciudad));
            this.operativoDao.ingresar(this.getOperativos());
            
            //PASES
            this.getPases().setIdAgente(this.getAgente());
            this.getPases().setIdTipoDocumento(new Parametros(this.idtipodocumentopases));           
            this.pasesDao.ingresar(this.getPases());
            
            //PERMISOS Y LICENCIAS
            this.getPermisos().setIdAgente(this.getAgente());
            this.getPermisos().setIdTipoPermiso(new Parametros(this.idtipopermiso));
            this.permisoDao.ingresar(this.getPermisos());          
            
            this.getListadoAgentes();

            //mensaje de finalizacion de grabado exitosamente
            this.ponerMensajeInfo("SE GRABO");
        }catch(Exception e){}
    }

    public void agregarDependiente(){        
        try{
            idDependienteTmp++;
            this.getDependiente().setIdAgente(this.getAgente());
            this.getDependiente().setIdDependiente(idDependienteTmp);
            this.getDependiente().setIdParentesco(parametroDao.obtenerParametroPorId(new Parametros(this.getIdparentesco())));
            this.listaDependientes.add(getDependiente());
            this.dependiente = new Dependiente();
        }catch(Exception e){
        }
    }
    
    public void agregarBanco(){
        try{
            idBancoTmp++;
            this.getCuentaBancos().setIdAgente(this.getAgente());
            this.getCuentaBancos().setIdBanco(idBancoTmp);
            this.getCuentaBancos().setIdNombrebanco(parametroDao.obtenerParametroPorId(new Parametros(this.getIdnombrebanco())));
            this.getCuentaBancos().setIdTipocuenta(parametroDao.obtenerParametroPorId(new Parametros(this.getIdtipocuenta())));
            //ponerMensajeAlerta("es:"+getCuentaBancos().getIdNombrebanco().getParametro());
             //ponerMensajeAlerta("es:"+getCuentaBancos().getIdTipocuenta().getParametro());
            // ponerMensajeAlerta("es:"+getCuentaBancos().getIdBanco());
            this.listaBancos.add(getCuentaBancos());
            this.cuentaBancos = new CuentaBancos();
        }catch(Exception e){
        }
    }
    
    public void agregarComunicado(){
        try {
            idComunicadoTmp++;
            this.getComunicados().setIdAgente(this.getAgente());
            this.getComunicados().setIdComunicado(idComunicadoTmp);
            this.getComunicados().setIdTipoComunicado(parametroDao.obtenerParametroPorId(new Parametros(this.getIdtipocomunicado())));
            this.listaComunicados.add(getComunicados());
            this.comunicados = new Comunicados();
            
        } catch (Exception e) {
        }
    }
    
    public void agregarCurso(){
        
        try {
            idCursoTmp++;
            this.getCursos().setIdAgente(this.getAgente());
            this.getCursos().setIdcurso(idCursoTmp);
            this.getCursos().setIdTipoCurso(parametroDao.obtenerParametroPorId(new Parametros(this.getIdtipocurso())));
            this.getCursos().setIdLugarCurso(parametroDao.obtenerParametroPorId(new Parametros(this.getIdlugarcurso())));
            this.listaCursos.add(getCursos());
            this.cursos = new Cursos();
        } catch (Exception e) {
        }
    }
    
    public void agregarFelicitacion(){
        try {
            idFelicitacionTmp++;
            this.getFelicitaciones().setIdAgente(this.getAgente());
            this.getFelicitaciones().setIdFelicitacion(idFelicitacionTmp);
            this.listaFelicitaciones.add(getFelicitaciones());
            this.felicitaciones = new Felicitaciones();
            
        } catch (Exception e) {
        }
    }
    
    public void agregarOperativos(){
        
        try {
            idOperativoTmp++;
            this.getOperativos().setIdAgente(this.getAgente());
            this.getOperativos().setIdOperativo(idOperativoTmp);
            this.getOperativos().setIdCiudad(parametroDao.obtenerParametroPorId(new Parametros(this.getIdciudad())));
            this.listaOperativos.add(getOperativos());
            this.operativos = new Operativos();
            
        } catch (Exception e) {
        }
    }
    
    public void agregrarPases(){
        try {
            idPaseTmp++;
            this.getPases().setIdAgente(this.getAgente());
            this.getPases().setIdPase(idPaseTmp);
            this.getPases().setIdTipoDocumento(parametroDao.obtenerParametroPorId(new Parametros(this.getIdtipodocumentopases())));
            this.listaPases.add(getPases());
            this.pases = new Pases();
        } catch (Exception e) {
        }
    }
    
    public void agregarPermisos(){
        try {
            idLicenciaTmp++;
            this.getPermisos().setIdAgente(this.getAgente());
            this.getPermisos().setIdPermiso(idLicenciaTmp);
            this.getPermisos().setIdTipoPermiso(parametroDao.obtenerParametroPorId(new Parametros(this.getIdtipopermiso())));
            this.listaLicencias.add(getPermisos());
            this.permisos = new Permisos();
            
        } catch (Exception e) {
        }
    }
    
    public Long getIdAgentes() {
        return idAgentes;
    }

    public void setIdAgentes(Long idAgentes) {
        this.idAgentes = idAgentes;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
//inicio variables paquete comun donde se asigna digito de tipo parametro
    public Long getGrado() {
        return GRADO;
    }

    public Long getSexo() {
        return SEXO;
    }

    public Long getEstado_Civil() {
        return ESTADO_CIVIL;
    }

    public Long getEstado() {
        return ESTADO;
    }

    public Long getSangre() {
        return SANGRE;
    }

    public Long getNivel_Educacion() {
        return NIVEL_EDUCACION;
    }

    public Long getTitulo() {
        return TITULO;
    }

    public Long getServicio() {
        return SERVICIO;
    }

    public Long getAgencia() {
        return AGENCIA;
    }

    public Long getDepartamento() {
        return DEPARTAMENTO;
    }

    public Long getLicencia_Conducir() {
        return LICENCIA_CONDUCIR;
    }
   
// fin de variables del paquete comun
    
    public Long getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Long idSexo) {
        this.idSexo = idSexo;
    }

    public Long getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Long idGrado) {
        this.idGrado = idGrado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getIdTipoParametro() {
        return idParametro;
    }

    public void setIdTipoParametro(Long idTipoParametro) {
        this.idParametro = idTipoParametro;
    }

    public Long getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Long idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Long getIdNivelEducacion() {
        return idNivelEducacion;
    }

    public void setIdNivelEducacion(Long idNivelEducacion) {
        this.idNivelEducacion = idNivelEducacion;
    }

    public Long getIdSangre() {
        return idSangre;
    }

    public void setIdSangre(Long idSangre) {
        this.idSangre = idSangre;
    }

    public Long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Long idTitulo) {
        this.idTitulo = idTitulo;
    }

    public Long getIdServicio() {
        return idServicio;
    }
    
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Long getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public DefaultStreamedContent getImagen() {
        return imagen;
    }

    public void setImagen(DefaultStreamedContent imagen) {
        this.imagen = imagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    
    
    //get y set parentesco
    public Dependiente getDependiente() {
        return dependiente;
    }

    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }
    
    public Long getIdparentesco() {
        return idparentesco;
    }

    public void setIdparentesco(Long idparentesco) {
        this.idparentesco = idparentesco;
    }

    // get y set bancos
    
       public CuentaBancos getCuentaBancos() {
        return cuentaBancos;
    }

    public void setCuentaBancos(CuentaBancos cuentaBancos) {
        this.cuentaBancos = cuentaBancos;
    }
    
    public Long getIdnombrebanco() {
        return idnombrebanco;
    }

    public void setIdnombrebanco(Long idnombrebanco) {
        this.idnombrebanco = idnombrebanco;
    }

    public Long getIdtipocuenta() {
        return idtipocuenta;
    }

    public void setIdtipocuenta(Long idtipocuenta) {
        this.idtipocuenta = idtipocuenta;
    }

    //get y set comunicados

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

    //get y ser cursos

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Long getIdtipocurso() {
        return idtipocurso;
    }

    public void setIdtipocurso(Long idtipocurso) {
        this.idtipocurso = idtipocurso;
    }

    public Long getIdlugarcurso() {
        return idlugarcurso;
    }

    public void setIdlugarcurso(Long idlugarcurso) {
        this.idlugarcurso = idlugarcurso;
    }
    
    //get y set felicitaciones

    public Felicitaciones getFelicitaciones() {
        return felicitaciones;
    }

    public void setFelicitaciones(Felicitaciones felicitaciones) {
        this.felicitaciones = felicitaciones;
    }
    
    //get y set operativos

    public Operativos getOperativos() {
        return operativos;
    }

    public void setOperativos(Operativos operativos) {
        this.operativos = operativos;
    }

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }
    
    //get y set Pases

    public Pases getPases() {
        return pases;
    }

    public void setPases(Pases pases) {
        this.pases = pases;
    }

    public Long getIdtipodocumentopases() {
        return idtipodocumentopases;
    }

    public void setIdtipodocumentopases(Long idtipodocumentopases) {
        this.idtipodocumentopases = idtipodocumentopases;
    }
    
    //get y set Permisos y licencias

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public Long getIdtipopermiso() {
        return idtipopermiso;
    }

    public void setIdtipopermiso(Long idtipopermiso) {
        this.idtipopermiso = idtipopermiso;
    }

    public List<Dependiente> getListaDependientes() {
        return listaDependientes;
    }

    public void setListaDependientes(List<Dependiente> listaDependientes) {
        this.listaDependientes = listaDependientes;
    }

    public List<CuentaBancos> getListaBancos() {
        return listaBancos;
    }

    public void setListaBancos(List<CuentaBancos> listaBancos) {
        this.listaBancos = listaBancos;
    }

    public List<Comunicados> getListaComunicados() {
        return listaComunicados;
    }

    public void setListaComunicados(List<Comunicados> listaComunicados) {
        this.listaComunicados = listaComunicados;
    }

    public List<Cursos> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Felicitaciones> getListaFelicitaciones() {
        return listaFelicitaciones;
    }

    public void setListaFelicitaciones(List<Felicitaciones> listaFelicitaciones) {
        this.listaFelicitaciones = listaFelicitaciones;
    }

    public List<Operativos> getListaOperativos() {
        return listaOperativos;
    }

    public void setListaOperativos(List<Operativos> listaOperativos) {
        this.listaOperativos = listaOperativos;
    }

    public List<Pases> getListaPases() {
        return listaPases;
    }

    public void setListaPases(List<Pases> listaPases) {
        this.listaPases = listaPases;
    }

    public List<Permisos> getListaLicencias() {
        return listaLicencias;
    }

    public void setListaLicencias(List<Permisos> listaLicencias) {
        this.listaLicencias = listaLicencias;
    }
    
   
}
