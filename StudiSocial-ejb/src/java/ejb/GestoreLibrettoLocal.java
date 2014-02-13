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
public interface GestoreLibrettoLocal {
 
    void createLibretto(String corsodistudi, Corso[] corsi, int[] voti);
    
    Double calcolaMedia();
    
    java.util.List<Corso> listCorsi();
    
}
