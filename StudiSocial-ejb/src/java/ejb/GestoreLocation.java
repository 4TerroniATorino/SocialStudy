/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Daniele
 */
@Stateless
public class GestoreLocation implements GestoreLocationLocal {
    
    public static final String TYPE_USER = "User";
    public static final String TYPE_GROUP = "Group";
    public static final String TYPE_ANNOUNCE = "Announce";
    public static final Double MAX_DISTANCE = 0.02;
    
    @EJB
    private LocationFacadeLocal locationFacade;
    
    @Override
    public void addLocation(String type, String via, Point2D.Double coordinata, String descrizione) {
        Location location = new Location();
        location.setCoordinate(coordinata);
        location.setType(type);
        location.setIndirizzo(via);
        location.setDescrizione(descrizione);
        locationFacade.create(location);
    }
    
    @Override
    public java.util.List<Location> listAll() {
        return locationFacade.findAll();
    }
    
    @Override
    public void removeLocation(Long id) {
        Location l = getLocation(id);
        if (l != null) {
            locationFacade.remove(l);
        }
    }
    
    @Override
    public Location getLocation(Long id) {
        List<Location> l = listAll();
        for (Location loc : l) {
            if (loc.getId().equals(id)) {
                return loc;
            }
        }
        return null;
    }
    
    @Override
    public java.util.List<Location> listUsers() {
        return listFiltered(TYPE_USER);
    }
    
    @Override
    public java.util.List<Location> listGroups() {
        return listFiltered(TYPE_GROUP);
    }
    
    @Override
    public java.util.List<Location> listAnnounce() {
        return listFiltered(TYPE_ANNOUNCE);
    }
    
    private java.util.List<Location> listFiltered(String type) {
        List<Location> all = listAll();
        List sel = new ArrayList();
        for (Location l : all) {
            if (l.getType().equals(type)) {
                sel.add(l);
            }
        }
        return sel;
    }
    
    @Override
    public java.util.List<Location> listCloseUsers(Location loc) {
        return listFilteredClose(TYPE_USER, loc);
    }
    
    @Override
    public java.util.List<Location> listCloseGroups(Location loc) {
        return listFilteredClose(TYPE_GROUP, loc);
    }
    
    @Override
    public java.util.List<Location> listCloseAnnounces(Location loc) {
        return listFilteredClose(TYPE_ANNOUNCE, loc);
    }
    
    private java.util.List<Location> listFilteredClose(String type, Location pos) {
        List<Location> all = listAll();
        List sel = new ArrayList();
        for (Location l : all) {
            if (l.getType().equals(type) && l.getCoordinate().distance(pos.getCoordinate()) <= MAX_DISTANCE) {
                sel.add(l);
            }
        }
        return sel;
    }
    
}
