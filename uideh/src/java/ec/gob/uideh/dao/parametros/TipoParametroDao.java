/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.parametros;

import ec.gob.uideh.agentes.entidades.TipoParametro;
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
public class TipoParametroDao {

    @PersistenceContext(unitName = "uidehPU")
    private EntityManager entityManager;

    public void ingresar(TipoParametro tipoParametro) {
        entityManager.persist(tipoParametro);
    }

    public void modificar(TipoParametro tipoParametro) {
        entityManager.merge(tipoParametro);
    }

    public void borra(TipoParametro tipoParametro) {
        entityManager.remove(entityManager.find(TipoParametro.class, tipoParametro.getId()));
    }
    
    public List<TipoParametro> listTipoParametro() throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT tipo_parametro FROM ec.gob.uideh.agentes.entidades.TipoParametro tipo_parametro ");
        consulta.append("ORDER BY tipo_parametro.id ");
        Query query = entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
}