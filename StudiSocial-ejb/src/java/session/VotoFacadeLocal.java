/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Utente;
import entity.Voto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface VotoFacadeLocal {

    void create(Voto voto);

    void edit(Voto voto);

    void remove(Voto voto);

    Voto find(Object id);

    List<Voto> findAll();
    
    List<Voto> findByUser(Utente utente);

    List<Voto> findRange(int[] range);

    int count();
    
}
