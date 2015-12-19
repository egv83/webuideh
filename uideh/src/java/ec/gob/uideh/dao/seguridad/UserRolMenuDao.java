/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.seguridad;

import ec.gob.uideh.menu.entidades.UserRolMenu;
import ec.gob.uideh.menu.entidades.UsuariosRoles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sistemas
 */
@Stateless
public class UserRolMenuDao {

    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;

    public void crear(UserRolMenu userRolMenu) {
        entityManager.persist(userRolMenu);
    }

    public void modificar(UserRolMenu userRolMenu) {
        entityManager.merge(userRolMenu);
    }

    public void eliminar(UserRolMenu userRolMenu) {
        UserRolMenu userRolMenus = entityManager.find(UserRolMenu.class, userRolMenu.getId());
        entityManager.remove(userRolMenus);
    }

    public List<UserRolMenu> listarUserRolMenu() {
        String consulta = "SELECT urm FROM ec.gob.uideh.menu.entidades.UserRolMenu urm ";
        Query query = entityManager.createQuery(consulta);
        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return query.getResultList();
        }
        return null;
    }

    /*public List<UserRolMenu> listarUsuarioRolMenu(UsuariosRoles usuariosRoles) {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT urm FROM ec.gob.uvcc.satus.modelo.seguridad.UserRolMenu urm ");
        consulta.append("WHERE urm.userRol.id=?1 ");
        //consulta.append("ORDER BY urm.menu.id");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuariosRoles.getId());

        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return query.getResultList();
        }
        return null;
    }*/
    
    public List<UserRolMenu> listarUsuarioRolMenuXRol(UsuariosRoles usuariosRoles) {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT urm FROM ec.gob.uideh.menu.entidades.UserRolMenu urm ");
        consulta.append("WHERE urm.rol.id=?1 ");
        //consulta.append("ORDER BY urm.menu.id");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuariosRoles.getRol().getId());

        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return query.getResultList();
        }
        return null;
    }

    public UserRolMenu usuarioRolMenu(UsuariosRoles usuariosRoles) {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT urm FROM ec.gob.uideh.menu.entidades.UserRolMenu urm ");
        consulta.append("WHERE urm.userRol.id=?1 ");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, usuariosRoles.getId());

        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return (UserRolMenu) query.getResultList().get(0);
        }
        return null;
    }
}
