/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author oneiros
 */
@Stateless
public class UtenteFacade extends AbstractFacade<Utente> implements UtenteFacadeLocal {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtenteFacade() {
        super(Utente.class);
    }
    
    @Override
    public Utente findByEmail(String email) {
        Query query = em.createNamedQuery("Utente.findByEmail").setParameter("email", email);
        return (Utente) query.getSingleResult();
    }
    
    @Override
    public Utente findByIdlog(String idlog) {
        Query query = em.createNamedQuery("Utente.findByIdlog").setParameter("idlog", idlog);
        return (Utente) query.getSingleResult();
    }
    
}
