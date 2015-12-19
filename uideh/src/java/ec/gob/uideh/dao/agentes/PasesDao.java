/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Pases;
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

public class PasesDao {
   @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar (Pases pases){
        entityManager.persist(pases);
    } 
    
    public void modificar(Pases pases){
        entityManager.merge(pases);
    }
    
    public List<Pases> listaPases()throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT pases FROM ec.gob.uideh.entidades.Pases pases ");
        consulta.append("ORDER BY pases.id_pase ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}
