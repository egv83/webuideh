/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.vehiculos;

import ec.gob.uideh.vehiculos.entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pablo
 */
public class VehiculosDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar(Vehiculo vehiculo){
        entityManager.persist(vehiculo);
    }
    
    public void modificar(Vehiculo vehiculo){
        entityManager.merge(vehiculo);
    }
    
    public void borra(Vehiculo vehiculo){
        entityManager.remove(entityManager.find(Vehiculo.class, vehiculo.getId()));
    }
    
       public List<Vehiculo> listaAgentes()throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT vehiculo FROM ec.gob.uideh.vehiculos.entidades.Vehiculo vehiculo ");
        consulta.append("ORDER BY vehiculo.id ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}
