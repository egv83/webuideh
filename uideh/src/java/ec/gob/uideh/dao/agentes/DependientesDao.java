/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Dependiente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pablo
 */
@Stateless
public class DependientesDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar (Dependiente dependiente){
        entityManager.persist(dependiente);
    }
    
    public void modificar (Dependiente dependiente){
        entityManager.persist(dependiente);
    }
    
    public void borrar (Dependiente dependiente){
        entityManager.remove(entityManager.find(Dependiente.class, dependiente.getIdDependiente()));
    }
    
    public List<Dependiente> listaDependiente()throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT dependiente FROM ec.gob.uideh.entidades.Dependiente dependiente ");
        consulta.append("ORDER BY dependiente.idDependiente ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
    
}
