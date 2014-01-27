/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Daniele
 */
@Stateless
public class GestoreIncontro implements GestoreIncontroLocal {

    @EJB
    private IncontroFacadeLocal incontroFacade;

    @Override
    public void addIncontro(Long ID, Gruppo gruppo, Location location, Date data) {
        Incontro inc = new Incontro();
        inc.setId(ID);
        inc.setGruppo(gruppo);
        inc.setLocation(location);
        inc.setData(data);
        incontroFacade.create(inc);
    }

    @Override
    public java.util.List<Incontro> listIncontri() {
        return incontroFacade.findAll();
    }

    @Override
    public void removeIncontro(Long id) {
        Incontro i = getIncontro(id);
        if (i != null) {
            incontroFacade.remove(i);
        }
    }

    @Override
    public Incontro getIncontro(Long id) {
        List<Incontro> l = listIncontri();
        for (Incontro i : l) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}
