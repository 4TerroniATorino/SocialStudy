/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.awt.geom.Point2D;
import javax.ejb.Local;

/**
 *
 * @author Daniele
 */
@Local
public interface GestoreLocationLocal {

    void addLocation(String type, String via, Point2D.Double coordinata, String descrizione);

    java.util.List<Location> listAll();

    void removeLocation(Long id);

    Location getLocation(Long id);

    java.util.List<Location> listUsers();

    java.util.List<Location> listGroups();

    java.util.List<Location> listAnnounce();

    java.util.List<Location> listCloseUsers(Location loc);

    java.util.List<Location> listCloseGroups(Location loc);

    java.util.List<Location> listCloseAnnounces(Location loc);
    
}
