/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.PhoneNumbers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface PhoneNumbersFacadeLocal {

    void create(PhoneNumbers phoneNumbers);

    void edit(PhoneNumbers phoneNumbers);

    void remove(PhoneNumbers phoneNumbers);

    PhoneNumbers find(Object id);

    List<PhoneNumbers> findAll();

    List<PhoneNumbers> findRange(int[] range);

    int count();
    
}
