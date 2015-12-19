/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.acceso;

import ec.gob.uideh.menu.entidades.Menuitems;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sistemas
 */
@Stateless
public class MenuitemsFacade extends AbstractFacade<Menuitems> {
    @PersistenceContext(unitName = "uidehPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuitemsFacade() {
        super(Menuitems.class);
    }
    
}
