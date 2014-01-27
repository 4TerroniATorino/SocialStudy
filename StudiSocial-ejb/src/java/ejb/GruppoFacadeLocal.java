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
public interface GruppoFacadeLocal {

    void create(Gruppo gruppo);

    void edit(Gruppo gruppo);

    void remove(Gruppo gruppo);

    Gruppo find(Object id);

    List<Gruppo> findAll();

    List<Gruppo> findRange(int[] range);

    int count();
    
}
