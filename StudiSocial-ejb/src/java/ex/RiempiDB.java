/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex;

import ejb.GestoreCorso;
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
    static GestoreCorso gestoreCorso = lookupGestoreCorsoBean1();
    static GestoreLocationLocal gestoreLocation = lookupGestoreLocationLocal1();
    
    public static void main(String[] args)
    {
        
        gestoreLocation.addLocation(1L, "Location", "via Pessinetto", null, "dipartimento di informatica");
        gestoreCorso.addCorso(1L, "Reti", "reti", "243", "Sereno", 9, 2, 23, "informatica", gestoreLocation.getLocation(1L));
        gestoreCorso.addCorso(2L, "Fisica", "fisica", "432", "Maggiora", 6, 1, 15, "fisica", gestoreLocation.getLocation(1L));
    }
    
    private static GestoreLocationLocal lookupGestoreLocationLocal1() {
        try {
            Context c = new InitialContext();
            return (GestoreLocationLocal) c.lookup("java:global/StudiSocial/StudiSocial-ejb/GestoreLocation!ejb.GestoreLocationLocal");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    private static GestoreCorso lookupGestoreCorsoBean1() {
        try {
            Context c = new InitialContext();
            return (GestoreCorso) c.lookup("java:global/StudiSocial/StudiSocial-ejb/GestoreCorso!ejb.GestoreCorso");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    
    
}
