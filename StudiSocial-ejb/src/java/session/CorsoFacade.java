/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Corso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author oneiros
 */
@Stateless
public class CorsoFacade extends AbstractFacade<Corso> implements CorsoFacadeLocal {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Corso findByNome(String nome) {
        Query query = em.createNamedQuery("Corso.findByName").setParameter("nome", nome);
        return findByQuery(query);
    }

    public CorsoFacade() {
        super(Corso.class);
    }
    
        private Corso findByQuery(Query query) {
        try {
            return (Corso) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
