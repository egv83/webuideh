/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.control.seguridad;

import ec.gob.uideh.comun.Comun;
import ec.gob.uideh.comun.sha1;
import ec.gob.uideh.dao.agentes.UsuariosDao;
import ec.gob.uideh.dao.parametros.ParametroDao;
import ec.gob.uideh.dao.parametros.UsuariosRolesDao;
import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.menu.entidades.Usuarios;
import ec.gob.uideh.menu.entidades.UsuariosRoles;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class UsuariosControl extends Comun implements Serializable {

    @EJB
    private UsuariosDao usuariosDao;
    @EJB
    private ParametroDao parametrosDao;
    @EJB
    private UsuariosRolesDao usuariosRolesDao;

    private Usuarios usuarios;
    private Usuarios usuario;
    private List<Usuarios> listaUsuarios;
    private List<Usuarios> listadoUsuarios;
    private Boolean opcion;
    private String verificarClave;
    private Long idRol;
    private Boolean checkEstado;
    private String nombres;
    private String apellidos;
    private String user;
    private String clave;

    public UsuariosControl() {
        this.usuarios = new Usuarios();
    }

    @PostConstruct
    public void iniciar() {
        try {
            this.listaUsuarios = usuariosDao.listarUsuarios();
            this.llenarListadoUsuarios();
        } catch (Exception e) {
            Logger.getLogger(UsuariosControl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void llenarListadoUsuarios() throws Exception {
        this.listadoUsuarios = new ArrayList<Usuarios>();
        this.listadoUsuarios = usuariosDao.listarUsuarios();
    }

    public void guardar() {
        //usuariosDao.crear(usuarios);
        //iniciar();
        Usuarios usr = new Usuarios();
        try {
            Parametros estado = new Parametros(this.asignarEstado());
            Parametros rol = new Parametros(this.getIdRol());
            UsuariosRoles usuariosRoles = new UsuariosRoles();
            usuariosRoles.setRol(rol);
            usr.setNombres(this.getNombres());
            usr.setApellidos(this.getApellidos());
            usr.setUsuario(this.getUser());
            usr.setEstado(estado);
            usr.setContrasena(sha1.encrypt64(this.getClave()));
            this.usuariosDao.crear(usr);
            usuariosRoles.setUsuarios(usr);
            this.usuariosRolesDao.crear(usuariosRoles);
            this.llenarListadoUsuarios();
            ponerMensajeInfo("USUARIO GUARDADO");
            execute("PF('usuarioDialog').hide();");
        } catch (Exception e) {
            ponerMensajeError("NO SE GUARDADO EL USUARIO");
        }
    }

    public void buscar() {
        listadoUsuarios = new ArrayList<Usuarios>();
        try {
            listadoUsuarios = usuariosDao.listarUsuarios(this.getUsuarios());
            this.limpiar();
        } catch (Exception e) {
        }
    }

    private void limpiar() {
        this.setUsuario(new Usuarios());
        this.setNombres(null);
        this.setApellidos(null);
        this.setIdRol(null);
        this.setUser(null);
        this.setClave(null);
        this.setCheckEstado(Boolean.FALSE);

        this.setIdRol(null);
        this.setCheckEstado(Boolean.FALSE);
    }

    public void nuevo() {
        this.setOpcion(Boolean.TRUE);
        this.limpiar();
    }

    public void editar(SelectEvent event) {
        this.setIdRol(null);
        try {
            this.setNombres(this.getUsuario().getNombres());
            this.setApellidos(this.getUsuario().getApellidos());
            this.setUser(this.getUsuario().getUsuario());
            this.setOpcion(Boolean.FALSE);
            this.obtenerActivo();
            this.setIdRol(usuariosRolesDao.buscarUsuarioRolxUsuario(this.getUsuario()).getRol().getId());
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        Parametros rol = new Parametros(this.getIdRol());
        Parametros estado = new Parametros(this.asignarEstado());
        UsuariosRoles usuariosRoles = usuariosRolesDao.buscarUsuarioRolxUsuario(this.getUsuario());
        try {
            this.getUsuario().setNombres(this.getNombres());
            this.getUsuario().setApellidos(this.getApellidos());
            this.getUsuario().setUsuario(this.getUser());
            ponerMensajeAlerta("ESTADO OBTENIDO: " + this.asignarEstado());
            this.getUsuario().setEstado(estado);
            usuariosRoles.setRol(rol);
            usuariosRoles.setUsuarios(this.getUsuario());

            if (!this.getVerificarClave().isEmpty()) {
                if (this.verificacionClaveModificar(this.getUsuario(), this.getVerificarClave())) {
                    if (this.getClave() != null && !this.getClave().isEmpty()) {
                        this.getUsuario().setContrasena(sha1.encrypt64(this.getClave()));
                        usuariosDao.modificar(this.getUsuario());
                        usuariosRolesDao.modificar(usuariosRoles);
                        this.limpiar();
                        ponerMensajeInfo("SE ACTUALIZO CONJUNTAMENTE CON LA CLAVE");
                        execute("PF('usuarioDialog').hide();");
                    } else {
                        ponerMensajeAlerta("INGRESE LA CLAVE Y REPÍTALA PARA COMPROBAR SI LA INGRESO CORRECTAMENTE");
                    }
                } else {
                    ponerMensajeAlerta("LA CLAVE DE VERIFICACION ANTERIOR NO ES CORRECTA");
                }
            } else {
                usuariosDao.modificar(this.getUsuario());
                usuariosRolesDao.modificar(usuariosRoles);
                this.limpiar();
                this.llenarListadoUsuarios();
                ponerMensajeInfo("SE ACTUALIZO CORRECTAMENTE");
                execute("PF('usuarioDialog').hide();");
            }
        } catch (Exception e) {
            ponerMensajeAlerta("ERROR AL ACTUALIZAR");
        }

    }

    public void eliminarUsuario() {
        try {
                eliminarUsuariosRoles();
                usuariosDao.eliminar(this.getUsuario());
                this.limpiar();
                this.llenarListadoUsuarios();
                execute("PF('usuarioDialog').hide();");
                ponerMensajeInfo("USUARIO ELIMINADO");
        } catch (Exception e) {
            ponerMensajeAlerta("NO SE ELIMINO EL USUARIO ");
        }
    }

    private void eliminarUsuariosRoles() {
        try {
            usuariosRolesDao.eliminar(usuariosRolesDao.usuarioRolesXUsuario(this.getUsuario()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SelectItem> getRoles() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        try {
            for (Parametros param : parametrosDao.listaEntidades(ROLES)) {
                lista.add(new SelectItem(param.getId(), param.getParametro()));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    private void obtenerActivo() {
        if (this.getUsuario().getEstado().getId().equals(ESTADO_ACTIVO)) {
            this.setCheckEstado(Boolean.TRUE);
        } else {
            this.setCheckEstado(Boolean.FALSE);
        }
    }

    private Long asignarEstado() {
        ponerMensajeAlerta("EN ASIGNAR ESTADO A USUARIO: " + this.getCheckEstado());
        if (this.getCheckEstado()) {
            return ESTADO_ACTIVO;
        }
        return ESTADO_INACTIVO;
    }

    private Boolean verificacionClaveModificar(Usuarios usuarios, String verificarClave) {
        Usuarios usr = usuariosDao.buscar(usuarios);
        if (usuariosDao.buscar(usuarios).getContrasena().equals(sha1.encrypt64(verificarClave))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * ***************
     *
     * GETTERS Y SETTERS
     *
     * @return
     */
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getCheckEstado() {
        return checkEstado;
    }

    public void setCheckEstado(Boolean checkEstado) {
        this.checkEstado = checkEstado;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getVerificarClave() {
        return verificarClave;
    }

    public void setVerificarClave(String verificarClave) {
        this.verificarClave = verificarClave;
    }

    public Boolean getOpcion() {
        return opcion;
    }

    public void setOpcion(Boolean opcion) {
        this.opcion = opcion;
    }

    public List<Usuarios> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuarios> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
