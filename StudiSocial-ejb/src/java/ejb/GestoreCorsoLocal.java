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
public interface GestoreCorsoLocal {
    void addCorso(String nome, String descrizione, String mfu, String docente, int crediti, int semestre, int numiscritti, String corsodistudi, Location location);
    
    Corso getCorso(Long ID);
    
    Corso getCorso(String nome);
    
    java.util.List<Corso> listCorsi();
}
