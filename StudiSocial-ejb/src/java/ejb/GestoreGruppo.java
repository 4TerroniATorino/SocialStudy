/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Daniele
 */
@Stateless
public class GestoreGruppo implements GestoreGruppoLocal {

    @EJB
    private GruppoFacadeLocal gruppoFacade;
    private GestoreUtenti user;

    @Override
    public void addGruppo(String nome, Utente fondatore, String argomenti, Corso corso) {
        Gruppo gr = new Gruppo();
        gr.setNome(nome);
        gr.setFondatore(fondatore);
        gr.setArgomenti(argomenti);
        gr.setCorso(corso);
        gruppoFacade.create(gr);
    }

    @Override
    public java.util.List<Gruppo> listGruppi() {
        return gruppoFacade.findAll();
    }

    @Override
    public void removeGruppo(Long id) {
        Gruppo g = getGruppo(id);
        if (g != null) {
            gruppoFacade.remove(g);
        }
    }

    @Override
    public Gruppo getGruppo(Long id) {
        List<Gruppo> l = listGruppi();
        for (Gruppo g : l) {
            if (g.getId().equals(id)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public void addUser(Long groupId, Long userId) {
        Gruppo g = getGruppo(groupId);
        g.getUtenti().add(user.getUser(userId));
    }

    @Override
    public void removeUser(Long groupId, Long userId) {
        Gruppo g = getGruppo(groupId);
        g.getUtenti().remove(user.getUser(userId));
    }
    
    

}
