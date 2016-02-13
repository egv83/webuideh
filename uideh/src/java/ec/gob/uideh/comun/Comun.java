/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.comun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pablo
 */
public class Comun {
    
    protected static final String FACES="/faces";
    
    protected static final Long ESTADO_ACTIVO=new Long("12");
    protected static final Long ESTADO_INACTIVO=new Long("13");
    protected static final Long ROLES= new Long("20");
     
    public final static String MENSAJE_CLIENTE="El usuario que va a guardar ya existe y sera asignado automaticamente";
    public final static String MENSAJE_MENU_ITEMS="INGRESE LOS DATOS EN EL CAMPO DESCRIPCIÓN";
    //public final static String MENSAJE_AUDIENCIAS="INGRESE TODOS LOS DATOS REQUERIDOS COMO TAMBIEN LAS PARTES PROCESALES";
    public final static String MENSAJE_ELIMINAR_MENU="NO SE PUEDE ELIMINAR PORQUE TIENE MENÚ HIJOS";
    
    protected static final String INGRESE_USUARIO_CLAVE="INGRESE EL USUARIO Y CLAVE";
    protected static final String NO_USUARIO="HO EXISTE EL USUARIO";
    protected static final String USUARIO_INACTIVO="EL USUARIO NO ESTA ACTIVADO";
    //variables para agente
    protected static final Long GRADO = new Long(1);
    protected static final Long SEXO = new Long(2);
    protected static final Long ESTADO_CIVIL = new Long(4);
    protected static final Long ESTADO = new Long(3);
    protected static final Long SANGRE = new Long(5);
    protected static final Long NIVEL_EDUCACION = new Long(6);
    protected static final Long TITULO = new Long(7);
    protected static final Long SERVICIO = new Long(9);
    protected static final Long AGENCIA = new Long(10);
    protected static final Long DEPARTAMENTO = new Long(11);
    protected static final Long LICENCIA_CONDUCIR = new Long(12);
    
    //variables para dependiente
    protected static final Long PARENTESCO = new Long(13);
    
    //Vehiculo
    protected static final Long MODELO_VEHICULO = new Long(22);
    protected static final Long CILINDRAJE_VEHICULO = new Long(23);
    protected static final Long ESTADO_VEHICULO = new Long(24);
    
    //variables para cuentabanco
    protected static final Long NOMBREBANCO = new Long(14);
    protected static final Long TIPOCUENTA = new Long(15);
    
    //variables para comunicado
    protected static final Long DOCUMENTO = new Long(16);
    
    //variables para cursos
    protected static final Long TIPOCURSO = new Long(17);
    protected static final Long CIUDADPAIS = new Long(18);
    
    //variable permisos
    protected static final Long TIPOPERMISO = new Long(19);
    
    protected static final String DESTINO_ARCHIVO = "C:\\imagen\\";
    
    
       protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
    
    protected void ponerMensajeInfo(String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensaje,null));
    }

    protected void ponerMensajeError(String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,null));
    }

    protected void ponerMensajeFatal(String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,mensaje,null));
    }
    
    protected void ponerMensajeAlerta(String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,mensaje,null));
    }
    
     protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }
    
     protected ExternalContext getExternalContext() {
        return getContext().getExternalContext();
    }
    
    protected static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
    public void execute(String componente) {
        getRequestContext().execute(componente);
    }
    
     protected RequestContext getRequestContext(){
        return RequestContext.getCurrentInstance();
    }
     
    protected void error(String clase, String mensaje, Exception e) {
        Logger.getLogger(clase).log(Level.SEVERE, mensaje.toUpperCase(), e);
    }
     
    protected void closeSession() {
        try {
            getExternalContext().redirect(getRequest().getContextPath() + "/faces/index.xhtml");
            HttpSession session = getSession();
            session.invalidate();
        } catch (Exception e) {
            error(getClass().getName(), "no se puede cerrar la sesión", e);
        }
    }
    
    //copiar imagen en archivo
    public void copyFile(String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(DESTINO_ARCHIVO + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("Nuevo Archivo Creado!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
}
