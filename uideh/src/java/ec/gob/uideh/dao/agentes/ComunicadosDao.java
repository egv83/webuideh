/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Comunicados;
import ec.gob.uideh.agentes.entidades.Parametros;
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
public class ComunicadosDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    
    public void ingresar (Comunicados comunicados){
        entityManager.persist(comunicados);
    }
    
    public void modificar(Comunicados comunicados){
        entityManager.merge(comunicados);
    }
    
    public void borra(Comunicados comunicados){
        entityManager.remove(entityManager.find(Comunicados.class, comunicados.getIdComunicado()));
    }
            
    
    public List<Comunicados>listacomunicados()throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT comunicados FROM ec.gob.uideh.entidades.Comunicados comunicados");
        consulta.append("ORDER BY comunicados.id_comunicado");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!= null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
    
}
