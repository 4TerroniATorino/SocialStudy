/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniele
 */
@Local
public interface GestoreUtentiLocal {
    
    void addUser(String id, String nome, String cognome, String username, String email, String password);
    
    void removeUser(String id);
    
    java.util.List<Utente> listUsers();
    
    Utente getUser(String idLog);
    
    Utente getUser(Long id);
    
    Utente getUserByEmail(String email);
    
    List<Utente> searchUsers(String key);
}
