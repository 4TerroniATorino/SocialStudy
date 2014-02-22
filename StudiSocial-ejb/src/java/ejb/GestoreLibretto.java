/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.Arrays;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Daniele
 */
@Stateless
public class GestoreLibretto implements GestoreLibrettoLocal {

    @EJB
    private LibrettoFacadeLocal librettoFacade;

    @Override
    public void createLibretto(String corsodistudi, Corso[] corsi, int[] voti) {
        Libretto lib = new Libretto();
        lib.setCorsodistudi(corsodistudi);
        lib.setCorsi(corsi);
        lib.setVoti(voti);
        librettoFacade.create(lib);
    }

    @Override
    public Double calcolaMedia() {
        int[] voti = librettoFacade.find(this).getVoti();
        double votoTot = 0d;
        for (int v : voti) {
            votoTot += v;
        }
        return votoTot / (double) (voti.length);
    }

    @Override
    public java.util.List<Corso> listCorsi() {
        Corso[] corsi = librettoFacade.find(this).getCorsi();
        return Arrays.asList(corsi);
    }

}
