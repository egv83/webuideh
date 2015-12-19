/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.seguridad;

import ec.gob.uideh.menu.entidades.Menuitems;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sistemas
 */
@LocalBean
@Stateless
public class MenuItemsDao {
    @PersistenceContext(unitName="uidehPU")
    private EntityManager entityManager;
    
    public void crear(Menuitems menuitems){
        entityManager.persist(menuitems);
    }
    
    public void modificar(Menuitems menuitems){
        entityManager.merge(menuitems);
        //entityManager.refresh(menuitems);
    }
    
    public void eliminar(Menuitems menuitems){
        Menuitems menuEliminar = entityManager.getReference(Menuitems.class, menuitems.getId());
        entityManager.remove(menuEliminar);
    }
    
    public Menuitems buscar(Menuitems menuitems){
        return entityManager.find(Menuitems.class, menuitems.getId());
    }
    
    public Boolean buscarMenuHijo(Menuitems menuitems){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ");
        consulta.append("WHERE m.idPadre=?1");
        Query query=entityManager.createQuery(consulta.toString());
        query.setParameter(1, menuitems.getId());
        if(!query.getResultList().isEmpty() && query.getResultList()!=null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    public List<Menuitems> listarMenus() throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ");
        Query query=entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty())
        {
            return query.getResultList();
        }
        return null;
    }
    
    public List<Menuitems> listarMenu() throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ORDER BY m.id ");
        Query query=entityManager.createQuery(consulta.toString());
        if(query.getResultList()!=null && !query.getResultList().isEmpty())
        {
            return query.getResultList();
        }
        return null;
    }
    
    public Menuitems menuItemXId(Menuitems menuItems)
    {
            StringBuilder consulta = new StringBuilder();
            consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ");
            consulta.append("WHERE m.id=?1 ");
            //consulta.append("ORDER BY m.idPadre ");
            Query query=entityManager.createQuery(consulta.toString());
            query.setParameter(1,menuItems.getIdPadre());
            if(query.getResultList()!=null && !query.getResultList().isEmpty()){
                return (Menuitems)query.getResultList().get(0);
            }
        return null;
    }
    
    public Menuitems menuItemXIdPadre(Menuitems menuitems){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ");
        consulta.append("WHERE m.idPadre=?1");
        Query query= entityManager.createQuery(consulta.toString());
        query.setParameter(1,menuitems.getId());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return (Menuitems)query.getResultList().get(0);
        }
        return null;
    }
    
    public List<Menuitems> menuItemXIdPadres(Menuitems menuitems){
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ");
        consulta.append("WHERE m.idPadre=?1");
        Query query= entityManager.createQuery(consulta.toString());
        query.setParameter(1,menuitems.getId());
        if(query.getResultList()!=null && !query.getResultList().isEmpty()){
            return query.getResultList();
        }
        return null;
    }
    
    public List<Menuitems> listarMenusLink() throws Exception{
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT m FROM ec.gob.uideh.menu.entidades.Menuitems m ");
        consulta.append("WHERE m.orden=?1");
        Query query=entityManager.createQuery(consulta.toString());
        query.setParameter(1,1);
        if(query.getResultList()!=null && !query.getResultList().isEmpty())
        {
            return query.getResultList();
        }
        return null;
    }
}
