/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Daniele
 */
@Stateless
public class GestoreAnnunci implements GestoreAnnunciLocal {

    @EJB
    private AnnuncioFacadeLocal annuncioFacade;

    @Override
    public void addAnnuncio(Utente user, String testo, Location loc) {
        Annuncio ann = new Annuncio();
        ann.setUser(user);
        ann.setTesto(testo);
        ann.setLocation(loc);
    }

    @Override
    public java.util.List<Annuncio> listAnnunci() {
        return annuncioFacade.findAll();
    }

    @Override
    public void removeAnnuncio(Long id) {
        Annuncio a = getAnnuncio(id);
        if (a != null) {
            annuncioFacade.remove(a);
        }
    }

    @Override
    public Annuncio getAnnuncio(Long id) {
        List<Annuncio> l = listAnnunci();
        for (Annuncio a : l) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

}
