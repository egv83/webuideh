/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.seguridad;

import ec.gob.uideh.menu.entidades.Roles;
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
public class RolesDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void crear(Roles roles){
        this.entityManager.persist(roles);
    }
    
    public void modificar(Roles roles){
        this.entityManager.merge(roles);
    }
    
    public void eliminar(Roles roles){
        this.entityManager.remove(roles);
    }
    
    public Roles buscar(Roles roles){
        return this.entityManager.find(Roles.class, roles);
    }
    
    public List<Roles> listaRoles(){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT roles FROM ec.gob.uideh.menu.entidades.Roles roles ");
        Query query=this.entityManager.createQuery(consulta.toString());
        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            return query.getResultList();
        }
        return null;
    }
}
