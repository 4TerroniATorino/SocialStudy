/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

/**
 *
 * @author Daniele
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestoreLocation gestLoc = new GestoreLocation();
        gestLoc.addLocation(1L, "Location", "via Pessinetto", null, "dipartimento di informatica");
        GestoreCorso gestCor = new GestoreCorso();
        gestCor.addCorso(1L, "Reti", "reti", "243", "Sereno", 9, 2, 23, "informatica", gestLoc.getLocation(1L));
        gestCor.addCorso(2L, "Fisica", "fisica", "432", "Maggiora", 6, 1, 15, "fisica", gestLoc.getLocation(1L));
    }
    
}
