/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

import ejb.GestoreCorso;
import ejb.GestoreCorsoLocal;
import ejb.GestoreLocation;
import ejb.GestoreLocationLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Michele
 */
public class RiempiDB {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        GestoreLocation gestoreLocation = new GestoreLocation();
        GestoreCorso gestoreCorso = new GestoreCorso();
        
        gestoreLocation.addLocation("Location", "via Pessinetto", null, "dipartimento di informatica");
        gestoreCorso.addCorso("Reti", "reti", "243", "Sereno", 9, 2, 23, "informatica", gestoreLocation.getLocation(1L));
        gestoreCorso.addCorso("Fisica", "fisica", "432", "Maggiora", 6, 1, 15, "fisica", gestoreLocation.getLocation(1L));
    }

}
