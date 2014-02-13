/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Local;

/**
 *
 * @author Daniele
 */
@Local
public interface GestoreGruppoLocal {
 
    void addGruppo(String nome, Utente fondatore, String argomenti, Corso corso);
    
    java.util.List<Gruppo> listGruppi();
    
    void removeGruppo(Long id);
    
    Gruppo getGruppo(Long id);
    
}
