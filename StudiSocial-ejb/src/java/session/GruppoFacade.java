/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Gruppo;
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
public class GruppoFacade extends AbstractFacade<Gruppo> implements GruppoFacadeLocal {

    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruppoFacade() {
        super(Gruppo.class);
    }

    @Override
    public List<Gruppo> findAllByFounder(Utente utente) {
        Query query = em.createNamedQuery("Gruppo.findByFondatoreId").setParameter("fondatore", utente);
        return query.getResultList();
    }

}
