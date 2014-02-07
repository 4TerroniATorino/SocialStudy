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
public class GestoreGruppo {

    @EJB
    private GruppoFacadeLocal gruppoFacade;

    public void addGruppo(Long ID, String nome, Utente fondatore, String argomenti, Corso corso) {
        Gruppo gr = new Gruppo();
        gr.setId(ID);
        gr.setNome(nome);
        gr.setFondatore(fondatore);
        gr.setArgomenti(argomenti);
        gr.setCorso(corso);
        gruppoFacade.create(gr);
    }

    public java.util.List<Gruppo> listGruppi() {
        return gruppoFacade.findAll();
    }

    public void removeGruppo(Long id) {
        Gruppo g = getGruppo(id);
        if (g != null) {
            gruppoFacade.remove(g);
        }
    }

    public Gruppo getGruppo(Long id) {
        List<Gruppo> l = listGruppi();
        for (Gruppo g : l) {
            if (g.getId().equals(id)) {
                return g;
            }
        }
        return null;
    }

}
