/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Libretto;
import entity.Location;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface LibrettoFacadeLocal {

    void create(Libretto libretto);

    void edit(Libretto libretto);

    void remove(Libretto libretto);

    Libretto find(Object id);

    List<Libretto> findAll();

    List<Libretto> findRange(int[] range);

    int count();
    
}
