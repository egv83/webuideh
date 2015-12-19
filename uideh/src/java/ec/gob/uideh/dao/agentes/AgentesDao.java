/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Agente;
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
public class AgentesDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    
    public void ingresar(Agente agente){
        entityManager.persist(agente);
    }
    
    public void modificar(Agente agente){
        entityManager.merge(agente);
    }
    
    public void borra(Agente agente){
        entityManager.remove(entityManager.find(Agente.class, agente.getIdAgente()));
    }
    
    public List<Agente> listaAgentes()throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT agente FROM ec.gob.uideh.entidades.Agente agente ");
        consulta.append("ORDER BY agente.idAgente ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}
