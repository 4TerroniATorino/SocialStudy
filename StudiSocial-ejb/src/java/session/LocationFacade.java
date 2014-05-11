/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Location;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oneiros
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> implements LocationFacadeLocal {
    
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    @Override
    public void addLocation(String type, String via, Point2D.Float coordinata, String descrizione) {
        Location location = new Location();
        location.setCoordinate(coordinata);
        location.setType(type);
        location.setIndirizzo(via);
        location.setDescrizione(descrizione);
        this.create(location);
    }
    
    @Override
    public java.util.List<Location> findUsers() {
        return findFiltered(TYPE_USER);
    }
    
    @Override
    public java.util.List<Location> findGroups() {
        return findFiltered(TYPE_GROUP);
    }
    
    @Override
    public List<Location> findAnnounce() {
        return findFiltered(TYPE_ANNOUNCE);
    }
    
    @Override
    public List<Location> findFiltered(String type) {
        List<Location> all = findAll();
        List sel = new ArrayList();
        for (Location l : all) {
            if (l.getType().equals(type)) {
                sel.add(l);
            }
        }
        return sel;
    }
    
    @Override
    public List<Location> findCloseUsers(Location loc) {
        return findFilteredClose(TYPE_USER, loc);
    }
    
    @Override
    public List<Location> findCloseGroups(Location loc) {
        return findFilteredClose(TYPE_GROUP, loc);
    }
    
    @Override
    public List<Location> findCloseAnnounces(Location loc) {
        return findFilteredClose(TYPE_ANNOUNCE, loc);
    }
    
    private List<Location> findFilteredClose(String type, Location pos) {
        List<Location> all = findAll();
        List sel = new ArrayList();
        for (Location l : all) {
            if (l.getType().equals(type) && l.getCoordinate().distance(pos.getCoordinate()) <= MAX_DISTANCE) {
                sel.add(l);
            }
        }
        return sel;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationFacade() {
        super(Location.class);
    }
    
}
