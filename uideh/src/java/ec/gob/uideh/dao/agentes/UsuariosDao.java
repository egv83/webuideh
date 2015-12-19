/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.menu.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuariosDao {

    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;

    Usuarios personal;

    public void crear(Usuarios usuarios) {
        entityManager.persist(usuarios);
    }

    public void modificar(Usuarios usuarios) {
        entityManager.merge(usuarios);
    }

    public void eliminar(Usuarios usuarios) {
        Usuarios usuario = entityManager.find(Usuarios.class, usuarios.getId());
        entityManager.remove(usuario);
    }

    public Usuarios buscar(Usuarios usuarios) {
        return entityManager.find(Usuarios.class, usuarios.getId());
    }

    public List<Usuarios> listarUsuarios() throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u FROM ec.gob.uideh.menu.entidades.Usuarios u ORDER BY u.id ");
        Query query = entityManager.createQuery(consulta.toString());
        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return query.getResultList();
        }
        return null;
    }

    public List<Usuarios> listarUsuarios(Usuarios usuarios) throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u FROM ec.gob.uideh.menu.entidades.seguridad.Usuarios u ");
        consulta.append("WHERE u.nombres LIKE LOWER(CONCAT(?1,'%')) ");
        consulta.append("AND u.apellidos LIKE LOWER(CONCAT(?2,'%')) ");

        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuarios.getNombres());
        query.setParameter(2, usuarios.getApellidos());
        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return query.getResultList();
        }
        return null;
    }

    public Usuarios obtenerUsuario(Usuarios usuario) throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u FROM ec.gob.uideh.menu.entidades.Usuarios u WHERE u.usuario=?1 AND u.contrasena=?2 ");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuario.getUsuario());
        query.setParameter(2, usuario.getContrasena());
        if (!query.getResultList().isEmpty() && query.getResultList() != null) {
            return (Usuarios) query.getResultList().get(0);
        }
        return null;
    }

    /*public Usuarios obtenerUsuarioXClave(Usuarios usuarios){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u FROM ec.gob.uvcc.satus.modelo.seguridad.Usuarios u ");
        consulta.append("WHERE u.contrasena=?1");
        Query query = this.entityManager.createQuery(consulta.toString());
        if(!query.getResultList().isEmpty() && query.getResultList() !=null){
            return (Usuarios)query.getResultList().get(0);
        }
        return null;
    }*/
}
