/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Cursos;
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

public class CursosDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar (Cursos cursos){
       entityManager.persist(cursos);
    }
    
     public void modificar (Cursos cursos){
        entityManager.merge(cursos);
    }
            
    public void eliminar (Cursos cursos){
        entityManager.remove(entityManager.find(Cursos.class,cursos.getIdcurso()));
    }
        
    public List<Cursos>listaCursos() throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT cursos FROM ec.gob.uideh.entidades.Cursos cursos");
        consulta.append("ORDEN BY cursos.idcurso");
        Query query = entityManager.createQuery(consulta.toString());
        if (query.getResultList()!= null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}
