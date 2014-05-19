/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Utente;
import entity.Voto;
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
public class VotoFacade extends AbstractFacade<Voto> implements VotoFacadeLocal {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VotoFacade() {
        super(Voto.class);
    }
    
    @Override
    public List<Voto> findByUser(Utente utente){
        Query query = em.createNamedQuery("Voto.findByIdUtente").setParameter("idUtente", utente.getId());
        return query.getResultList();
    }
    
}
