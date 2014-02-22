/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex;

import ejb.GestoreLocation;
import ejb.GestoreLocationLocal;

/**
 *
 * @author Michele
 */
public class RiempiDB {
    static GestoreLocationLocal gestoreLocation;
    
    public static void main(String[] args)
    {
        gestoreLocation = new GestoreLocation();

        GestoreLocation gestoreLocation = new GestoreLocation();

        gestoreLocation.addLocation("Location", "via Pessinetto", null, "dipartimento di informatica");
    }
}
