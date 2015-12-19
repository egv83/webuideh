/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.CuentaBancos;
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

public class CuentaBancosDao {
    
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar (CuentaBancos cuentaBancos){
        entityManager.persist(cuentaBancos);
    }
    
    public void modificar (CuentaBancos cuentaBancos){
        entityManager.merge(cuentaBancos);
    }
            
    public void eliminar (CuentaBancos cuentaBancos){
        entityManager.remove(entityManager.find(CuentaBancos.class, cuentaBancos.getIdBanco()));
    }
    
    public List<CuentaBancos> listaCuentaBancos()throws Exception {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT cuentabancos FROM ec.gob.uideh.entidades.CuentaBancos cuentabancos ");
        consulta.append("ORDER BY cuentabancos.idBanco ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
   
}
