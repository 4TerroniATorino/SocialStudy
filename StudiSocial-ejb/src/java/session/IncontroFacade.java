/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Incontro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oneiros
 */
@Stateless
public class IncontroFacade extends AbstractFacade<Incontro> implements IncontroFacadeLocal {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncontroFacade() {
        super(Incontro.class);
    }
    
}
