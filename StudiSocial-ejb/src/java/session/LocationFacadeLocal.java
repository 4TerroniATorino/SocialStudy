/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Location;
import java.awt.geom.Point2D;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oneiros
 */
@Local
public interface LocationFacadeLocal {
    
    public static final String TYPE_USER = "User";
    public static final String TYPE_GROUP = "Group";
    public static final String TYPE_ANNOUNCE = "Announce";
    public static final String TYPE_DEPARTMENT = "Dipartimento";
    public static final String TYPE_STUDY_HALL = "Aula Studio";
    public static final String TYPE_LIBRARY = "Biblioteca";
    public static final Double MAX_DISTANCE = 0.02;
    
    void addLocation(String type, String via, Point2D.Float coordinata, String descrizione);

    List<Location> findUsers();

    List<Location> findGroups();

    List<Location> findAnnounce();

    List<Location> findCloseUsers(Location loc);

    List<Location> findCloseGroups(Location loc);

    List<Location> findCloseAnnounces(Location loc);
    
    List<Location> findFiltered(String type);

    void create(Location location);

    void edit(Location location);

    void remove(Location location);

    Location find(Object id);

    List<Location> findAll();

    List<Location> findRange(int[] range);

    int count();
    
}
