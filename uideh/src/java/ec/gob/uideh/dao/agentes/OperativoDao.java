/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.agentes;

import ec.gob.uideh.agentes.entidades.Operativos;
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

public class OperativoDao {
    
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar(Operativos operativos){
        entityManager.persist(operativos);
    }
    
    public void modificar (Operativos operativos){
        entityManager.merge(operativos);
    }
    
    
    public List<Parametros> listparametros() throws Exception
    {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT parametros FROM ec.gob.uideh.entidades.Parametros parametros ORDER BY parametros.id ");
        Query query = entityManager.createQuery(consulta.toString());
        if (query.getResultList()!= null && !query.getResultList().isEmpty())
        {
            return query.getResultList();
        }
        return null;
    }
    
    public List<Operativos>listaOperativos()throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT operativos FROM ec.gob.uideh.entidades.Operativos operativos");
        consulta.append("ORDER BY operativos.id_operativo");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}
