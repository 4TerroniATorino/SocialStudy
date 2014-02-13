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
public interface GestoreAnnunciLocal {
    void addAnnuncio(Utente user, String testo, Location loc);
    
    java.util.List<Annuncio> listAnnunci();
    
    void removeAnnuncio(Long id);
    
    Annuncio getAnnuncio(Long id);
}
