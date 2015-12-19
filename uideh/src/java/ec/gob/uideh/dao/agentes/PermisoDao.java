/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Permisos;
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
public class PermisoDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
public void ingresar(Permisos permisos){
    entityManager.persist(permisos);
}
 
public void modificar(Permisos permisos){
    entityManager.persist(permisos);
}

public List<Permisos> listaPermisos()throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT permisos FROM ec.gob.uideh.entidades.Permisos permisos ");
        consulta.append("ORDER BY permisos.idPermiso ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}
