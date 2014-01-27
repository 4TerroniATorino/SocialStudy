/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Daniele
 */
@Stateless
@LocalBean
public class GestoreAnnunci {

    @EJB
    private AnnuncioFacadeLocal annuncioFacade;

    public void addAnnuncio(Long ID, User user, String testo, Location loc) {
        Annuncio ann = new Annuncio();
        ann.setId(ID);
        ann.setUser(user);
        ann.setTesto(testo);
        ann.setLocation(loc);
    }

    public java.util.List<Annuncio> listAnnunci() {
        return annuncioFacade.findAll();
    }

    public void removeAnnuncio(Long id) {
        Annuncio a = getAnnuncio(id);
        if (a != null) {
            annuncioFacade.remove(a);
        }
    }

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
