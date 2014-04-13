/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.GruppoUtente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface GruppoUtenteFacadeLocal {

    void create(GruppoUtente gruppoUtente);

    void edit(GruppoUtente gruppoUtente);

    void remove(GruppoUtente gruppoUtente);

    GruppoUtente find(Object id);

    List<GruppoUtente> findAll();

    List<GruppoUtente> findRange(int[] range);

    int count();
    
}
