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
public class GestoreCorso implements GestoreCorsoLocal {

    @EJB
    private CorsoFacadeLocal corsoFacade;

    @Override
    public void addCorso(String nome, String descrizione, String mfu, String docente, int crediti, int semestre, int numiscritti, String corsodistudi, Location location) {
        Corso c = new Corso();
        c.setNome(nome);
        c.setDescrizione(descrizione);
        c.setMfu(mfu);
        c.setDocente(docente);
        c.setCrediti(crediti);
        c.setSemestre(semestre);
        c.setNum_iscritti(numiscritti);
        c.setCorsoDiStudi(corsodistudi);
        c.setLocation(location);
        corsoFacade.create(c);
    }

    @Override
    public Corso getCorso(Long ID) {
        List<Corso> l = listCorsi();
        for (Corso c : l) {
            if (c.getId().equals(ID)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Corso getCorso(String nome) {
        List<Corso> l = listCorsi();
        for (Corso c : l) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public java.util.List<Corso> listCorsi() {
        return corsoFacade.findAll();
    }

}
