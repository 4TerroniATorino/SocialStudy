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
public interface UtenteFacadeLocal {

    void create(Utente user);

    void edit(Utente user);

    void remove(Utente user);

    Utente find(Object id);

    List<Utente> findAll();

    List<Utente> findRange(int[] range);

    int count();
    
}
