/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Daniele
 */
@Stateless
public class GestoreUtenti implements GestoreUtentiLocal {

    @EJB
    private UtenteFacadeLocal userFacade;

    @Override
    public void addUser(String id, String nome, String cognome, String username, String email, String password) {
        Utente user = new Utente();
        user.setId(id);
        user.setNome(nome);
        user.setCognome(cognome);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        userFacade.create(user);
    }

    @Override
    public void removeUser(String id) {
        Utente u = getUser(id);
        if (u != null) {
            userFacade.remove(u);
        }
    }

    @Override
    public java.util.List<Utente> listUsers() {
        return userFacade.findAll();
    }

    @Override
    public Utente getUser(String id) {
        List<Utente> l = listUsers();
        for (Utente u : l) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Utente> searchUsers(String key) {
        List<Utente> l = listUsers();
        List<Utente> out = new ArrayList();
        for (Utente u : l) {
            if (u.getNome().equalsIgnoreCase(key) || u.getCognome().equalsIgnoreCase(key)
                    || u.getUsername().equalsIgnoreCase(key)) {
                out.add(u);
            }
        }
        return out;
    }

}
