/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Felicitaciones;
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

public class FelicitacionDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar (Felicitaciones felicitaciones){
        entityManager.persist(felicitaciones);
    }
    
     public void modificar (Felicitaciones felicitaciones){
        entityManager.merge(felicitaciones);
    }
            
    public void eliminar (Felicitaciones felicitaciones){
        entityManager.remove(entityManager.find(Felicitaciones.class, felicitaciones.getIdFelicitacion()));
    }
        
    public List<Felicitaciones>listaFelicitaciones() throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT felicitaciones FROM ec.gob.uideh.entidades.Felicitaciones felicitaciones");
        consulta.append("ORDEN BY felicitaciones.idfelicitacion");
        Query query = entityManager.createQuery(consulta.toString());
        if (query.getResultList()!= null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
    
}
