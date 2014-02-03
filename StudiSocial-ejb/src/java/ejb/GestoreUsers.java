/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Daniele
 */
@Stateless
@LocalBean
public class GestoreUsers {

    @EJB
    private UserFacadeLocal userFacade;

    public void addUser(Long id, String nome, String cognome, String username, String email, String password) {
        User user = new User();
        user.setId(id);
        user.setNome(nome);
        user.setCognome(cognome);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        userFacade.create(user);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void removeUser(Long id) {
        User u = getUser(id);
        if (u != null) {
            userFacade.remove(u);
        }
    }

    public java.util.List<User> listUsers() {
        return userFacade.findAll();
    }

    public User getUser(Long id) {
        List<User> l = listUsers();
        for (User u : l) {
            if (u.getID().equals(id)) {
                return u;
            }
        }
        return null;
    }

}