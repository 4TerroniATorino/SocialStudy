package service;

import entity.Location;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import session.LocationFacadeLocal;

/**
 *
 * @author Michele
 */
@WebService(serviceName = "LocationSOAP")
public class LocationSOAP {
    
    @EJB private LocationFacadeLocal ejbRef;

    @WebMethod(operationName = "findLocations")
    public List<Location> findAll() {
        return ejbRef.findAll();
    }
    
}
