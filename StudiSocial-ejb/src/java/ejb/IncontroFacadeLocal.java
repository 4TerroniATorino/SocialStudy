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
public interface IncontroFacadeLocal {

    void create(Incontro incontro);

    void edit(Incontro incontro);

    void remove(Incontro incontro);

    Incontro find(Object id);

    List<Incontro> findAll();

    List<Incontro> findRange(int[] range);

    int count();
    
}
