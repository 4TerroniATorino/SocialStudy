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
public interface CorsoFacadeLocal {

    void create(Corso corso);

    void edit(Corso corso);

    void remove(Corso corso);

    Corso find(Object id);

    List<Corso> findAll();

    List<Corso> findRange(int[] range);

    int count();
    
}