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
public class GestoreCorso {

    
    @EJB
    private CorsoFacadeLocal corsoFacade;
    public Corso getCorso(Long ID) {
       List<Corso> l = listCorsi();
        for (Corso c : l) {
            if (c.getId().equals(ID)) {
                return c;
            }
        }
        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public java.util.List<Corso> listCorsi() {
        return corsoFacade.findAll();
    }
}
