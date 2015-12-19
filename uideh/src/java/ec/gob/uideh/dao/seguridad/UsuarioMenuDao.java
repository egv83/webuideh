/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.dao.seguridad;

import ec.gob.uideh.menu.entidades.UsuarioMenu;
import ec.gob.uideh.menu.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sistemas
 */
@Stateless
public class UsuarioMenuDao {
    @PersistenceContext(unitName="uidehPU")
    private EntityManager entityManager;
    
    public void crear(UsuarioMenu usuarioMenu){
        entityManager.persist(usuarioMenu);
    }
    
    public void modificar(UsuarioMenu usuarioMenu){
        entityManager.merge(usuarioMenu);
    }
    
    public void eliminar(UsuarioMenu usuarioMenu){
        entityManager.remove(entityManager.find(UsuarioMenu.class, usuarioMenu.getId()));
    }
    
    public List<UsuarioMenu> listarUsuarioMenu(){
        try{
            StringBuilder consulta = new StringBuilder();
            consulta.append("SELECT um FROM ec.gob.uideh.menu.entidades.UsuarioMenu um ");
            Query query=entityManager.createQuery(consulta.toString());
            if(query.getResultList()!=null && !query.getResultList().isEmpty()){
                return query.getResultList();
            }
        }catch(Exception e){

        }
        return null;
    }
    
    public List<UsuarioMenu> listarUsuarioMenu(Usuarios usuario){
        try{
            StringBuilder consulta = new StringBuilder();
            consulta.append("SELECT um FROM ec.gob.uideh.menu.entidades.UsuarioMenu um ");
            consulta.append("WHERE um.usuario.id=?1");
            Query query=entityManager.createQuery(consulta.toString());
            query.setParameter(1,usuario.getId());
            if(query.getResultList()!=null && !query.getResultList().isEmpty()){
                return query.getResultList();
            }
        }catch(Exception e){

        }
        return null;
    }
}
