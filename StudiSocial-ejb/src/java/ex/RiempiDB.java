/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

import ejb.GestoreLocationLocal;
import javax.ejb.EJB;

/**
 *
 * @author Michele
 */
public class RiempiDB {
    @EJB
    static GestoreLocationLocal gestoreLocation;
    
    
    public static void main(String[] args) {
        /*
         * Leggo su internet che una cosa del genere non si può fare.
         * Bisogna creare un nuovo modulo EJB per fare del testing
         * Fai prima ad usare la servlet Location, così:
         * http://localhost:8080/StudiSocial-war/Location?action=add&output=json&type=Location&address=Via%20Pessinetto%2012&description=Dipartimento%20di%20Informatica&locx=10&locy=10
         */
        gestoreLocation.addLocation("Location", "via Pessinetto", null, "dipartimento di informatica");
    }
}
