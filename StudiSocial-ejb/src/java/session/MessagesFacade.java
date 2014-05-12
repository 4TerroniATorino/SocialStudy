/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Messages;
import entity.PhoneNumbers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oneiros
 */
@Stateless
public class MessagesFacade extends AbstractFacade<Messages> implements MessagesFacadeLocal {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessagesFacade() {
        super(Messages.class);
    }

    @Override
    public List<Messages> findAllByRecipient(PhoneNumbers phoneNumber) {
        return em.createNamedQuery("Messages.findByRecipient")
                .setParameter("recipient", phoneNumber)
                .getResultList();
    }
    
    
    
}
