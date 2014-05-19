/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Corso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface CorsoFacadeLocal {

    void create(Corso corso);

    void edit(Corso corso);

    void remove(Corso corso);

    Corso find(Object id);
    
    Corso findByNome(String nome);

    List<Corso> findAll();

    List<Corso> findRange(int[] range);

    int count();
    
}
