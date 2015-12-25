/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.parametros;

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
public class ParametroDao {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;
    
    public void ingresar (Parametros parametros){
        entityManager.persist(parametros);
    }
    
    public void modificar (Parametros parametros){
        entityManager.merge(parametros);
    }
            
    public void eliminar (Parametros parametros){
        entityManager.remove(entityManager.find(Parametros.class, parametros.getId()));
    }
    
    public List<Parametros> listparametros() throws Exception
    {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT parametros FROM ec.gob.uideh.agentes.entidades.Parametros parametros ORDER BY parametros.id ");
        Query query = entityManager.createQuery(consulta.toString());
        if (query.getResultList()!= null && !query.getResultList().isEmpty())
        {
            return query.getResultList();
        }
        return null;
    }
    
    public List<Parametros> listaEntidades(Long tipoParametro) throws Exception {        
       StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT parametros FROM ec.gob.uideh.agentes.entidades.Parametros parametros ");
        consulta.append("WHERE parametros.idTipoParametro.id=?1 ");
        consulta.append("ORDER BY parametros.parametro ");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, tipoParametro);
        if(query.getResultList()!= null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
    
    public List<Parametros> listarParametros(Long idTipoParam) throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT parametros FROM ec.gob.uideh.agentes.entidades.Parametros parametros ");
        consulta.append("WHERE parametros.idTipoParametro.id=?1 ");
        consulta.append("ORDER BY parametros.parametro ");
        Query query = entityManager.createQuery(consulta.toString());
        query.setParameter(1, idTipoParam);
        System.out.println("TAMAÑO LISTA PARAMETROS: "+query.getResultList().size());
        if(query.getResultList()!= null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
    
    public Parametros obtenerParametroPorId(Parametros parametro) throws Exception{
        return entityManager.find(Parametros.class, parametro.getId());
    }
}
