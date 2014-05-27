/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.Location;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Michele
 */
@Stateless
@Path("location")
public class LocationFacadeREST {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    private final Class<Location> entityClass = Location.class;
    
    @GET
    @Path(value="list/xml")
    @Produces("application/xml")
    public List<Location> findAllXML() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    @GET
    @Path(value="list/json")
    @Produces("application/json")
    public List<Location> findAllJSON() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
}
