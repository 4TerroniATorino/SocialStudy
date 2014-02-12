/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Arrays;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Daniele
 */
@Stateless
@LocalBean
public class GestoreLibretto {

    @EJB
    private LibrettoFacadeLocal librettoFacade;

    public void createLibretto(Long ID, String corsodistudi, Corso[] corsi, int[] voti) {
        Libretto lib = new Libretto();
        lib.setId(ID);
        lib.setCorsodistudi(corsodistudi);
        lib.setCorsi(corsi);
        lib.setVoti(voti);
        librettoFacade.create(lib);
    }

    public Double calcolaMedia() {
        int[] voti = librettoFacade.find(this).getVoti();
        double votoTot = 0d;
        for (int v : voti) {
            votoTot += v;
        }
        return votoTot / (double) (voti.length);
    }

    public java.util.List<Corso> listCorsi() {
        Corso[] corsi = librettoFacade.find(this).getCorsi();
        return Arrays.asList(corsi);
    }

}
