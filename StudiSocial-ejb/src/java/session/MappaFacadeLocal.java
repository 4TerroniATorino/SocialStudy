/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Mappa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface MappaFacadeLocal {

    void create(Mappa mappa);

    void edit(Mappa mappa);

    void remove(Mappa mappa);

    Mappa find(Object id);

    List<Mappa> findAll();

    List<Mappa> findRange(int[] range);

    int count();
    
}
