/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.parametros;

import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.menu.entidades.Usuarios;
import ec.gob.uideh.menu.entidades.UsuariosRoles;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sistemas
 */
@LocalBean
@Stateless
public class UsuariosRolesDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public String test(){
        return "ENTRO EN TEST DE USUARIO R DAO";
    }
    public void crear(UsuariosRoles usuariosRoles){
        this.entityManager.persist(usuariosRoles);
    }
    
    public void modificar(UsuariosRoles usuariosRoles){
        this.entityManager.merge(usuariosRoles);
    }
    
    public void eliminar(UsuariosRoles usuariosRoles){
        UsuariosRoles usuariosRoles1 = entityManager.find(UsuariosRoles.class, usuariosRoles.getId());
        this.entityManager.remove(usuariosRoles1);
    }
    
    public UsuariosRoles buscar(UsuariosRoles usuariosRoles){
        return this.entityManager.find(UsuariosRoles.class,usuariosRoles.getId());
    }
    
    public UsuariosRoles burcarXUsuario(Usuarios usuarios){
        System.out.println("ENTRO EN BUSCAR X USUARIO: "+usuarios.getId());
        UsuariosRoles usr=this.entityManager.find(UsuariosRoles.class, usuarios.getId());
        System.out.println("ID ROL: "+usr.getRol().getId());
        return this.entityManager.find(UsuariosRoles.class, usuarios.getId());
    }
    
    /*public List<UsuariosRoles> listaUsuarioRolesXUsuario(Usuarios usuario){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ur FROM ec.gob.uvcc.satus.modelo.seguridad.UsuariosRoles ur ");
        consulta.append("WHERE ur.usuarios.id=?1 ");
        Query query=entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuario.getId());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }*/
    
    public UsuariosRoles usuarioRolesXUsuario(Usuarios usuario){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ur FROM ec.gob.uideh.menu.entidades.UsuariosRoles ur ");
        consulta.append("WHERE ur.usuarios.id=?1 ");
        Query query=entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuario.getId());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return (UsuariosRoles)query.getResultList().get(0);
        }
        return null;
    }
    
    public UsuariosRoles buscarUsuarioRolxUsuario(Usuarios usuarios)
    {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ur FROM ec.gob.uideh.menu.entidades.UsuariosRoles ur ");
        consulta.append("WHERE ur.usuarios.id=?1 ");
        Query query=entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuarios.getId());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return (UsuariosRoles)query.getResultList().get(0);
        }
        return null;
    }
    
    public List<UsuariosRoles> listaUsuariosRoles(){
        System.out.println("ENTRO EN LISTAR USUARIOS ROLES EN DAO");
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ur FROM ec.gob.uideh.menu.entidades.UsuariosRoles ur ");
        Query query=this.entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            System.out.println("ENTRO EN IF");
            System.out.println(query.getResultList());
            return query.getResultList();
        }
        return null;
    }
    
    public List<UsuariosRoles>listaUsuariosRolesXRol(Parametros roles,Parametros estado){
        System.out.println("ENTRO EN LISTAR USUARIOS ROLES POR ROL");
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT ur FROM ec.gob.uideh.menu.entidades.UsuariosRoles ur ");
        consulta.append("WHERE ur.rol.id=?1 ");
        consulta.append("AND ur.usuarios.estado.id=?2 ");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, roles.getId());
        query.setParameter(2, estado.getId());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}