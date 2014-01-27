/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.sql.Date;
import javax.ejb.Local;

/**
 *
 * @author Daniele
 */
@Local
public interface GestoreIncontroLocal {

    void addIncontro(Long ID, Gruppo gruppo, Location location, Date data);

    java.util.List<Incontro> listIncontri();

    void removeIncontro(Long id);

    Incontro getIncontro(Long id);
    
}
