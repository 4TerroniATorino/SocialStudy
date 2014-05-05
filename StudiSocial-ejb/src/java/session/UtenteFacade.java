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

/**
 *
 * @author oneiros
 */
@Stateless
public class UtenteFacade extends AbstractFacade<Utente> implements UtenteFacadeLocal {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;
    
    @Override
    public Utente getUserByEmail(String email) {
        List<Utente> l = findAll();
        for (Utente u : l) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtenteFacade() {
        super(Utente.class);
    }

    @Override
    public Utente find(String idlog) {
        List<Utente> l = findAll();
        for (Utente u : l) {
            if (u.getIdlog() != null && u.getIdlog().equals(idlog)) {
                return u;
            }
        }
        return null;
    }
    
}
