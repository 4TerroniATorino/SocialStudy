/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.Location;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Michele
 */
@Stateless
@Path("location")
public class LocationFacadeREST extends AbstractFacade<Location> {
    @PersistenceContext(unitName = "Studisocial")
    private EntityManager em;

    public LocationFacadeREST() {
        super(Location.class);
    }
    
    @GET
    @Override
    @Path(value="list")
    @Produces({"application/xml", "application/json"})
    public List<Location> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
