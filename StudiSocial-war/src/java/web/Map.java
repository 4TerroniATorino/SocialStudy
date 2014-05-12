/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.LocationFacadeLocal;

/**
 *
 * @author Daniele, oneiros
 */
@WebServlet(name = "Map", urlPatterns = {"/Map"})
public class Map extends HttpServlet {

    @EJB
    private LocationFacadeLocal locationsManager;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext cxt = getServletContext();
        String action = request.getParameter("action");
        String output = request.getParameter("output");
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", "map");
        
        if (action == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must provide an action");
            return;
        } 
        else if (action.equalsIgnoreCase("show")){
            List<entity.Location> locations1 = this.locationsManager.findFiltered(LocationFacadeLocal.TYPE_DEPARTMENT);
            List<entity.Location> locations2 = this.locationsManager.findFiltered(LocationFacadeLocal.TYPE_STUDY_HALL);
            List<entity.Location> locations3 = this.locationsManager.findFiltered(LocationFacadeLocal.TYPE_LIBRARY);
            map.put("locations1", locations1);
            map.put("locations2", locations2);
            map.put("locations3", locations3);
        }
        else if (action.equalsIgnoreCase("add")) {
            String type = request.getParameter("type");
            String address = request.getParameter("address");
            Point2D.Float coords = getCurrentLocation(request);
            String description = request.getParameter("description");
            locationsManager.addLocation(type, address, coords, description);
            map.put("output", "Gruppo aggiunto");
        } 
        else if (action.equalsIgnoreCase("remove")) {
            long id = Long.parseLong(request.getParameter("id"));
            entity.Location loc = locationsManager.find(id);
            locationsManager.remove(loc);
            map.put("output", "Location eliminata");
        } 
        else if (action.equalsIgnoreCase("listAll")) {
            List<entity.Location> loc = locationsManager.findAll();
            for (entity.Location l : loc){
                System.out.println(l);
            }
            map.put("all", loc);
        } 
        else if (action.equalsIgnoreCase("listUsers")) {
            List<entity.Location> users = locationsManager.findUsers();
            map.put("users", users);
        } 
        else if (action.equalsIgnoreCase("listGroups")) {
            List<entity.Location> groups = locationsManager.findGroups();
            map.put("groups", groups);
        } 
        else if (action.equalsIgnoreCase("listAnnounces")) {
            List<entity.Location> announces = locationsManager.findAnnounce();
            map.put("announces", announces);
        } 
        else if (action.equalsIgnoreCase("listCloseUsers")) {
            entity.Location attuale = new entity.Location();        
            attuale.setCoordinate(getCurrentLocation(request));        
            List<entity.Location> users = locationsManager.findCloseUsers(attuale);
            map.put("closeUsers", users);
        } 
        else if (action.equalsIgnoreCase("listCloseGroups")) {
            entity.Location attuale = new entity.Location();
            attuale.setCoordinate(getCurrentLocation(request));            
            List<entity.Location> groups = locationsManager.findCloseGroups(attuale);
            map.put("closeGroups", groups);
        } 
        else if (action.equalsIgnoreCase("listCloseAnnounces")) {
            entity.Location attuale = new entity.Location();       
            attuale.setCoordinate(getCurrentLocation(request));        
            List<entity.Location> announces = locationsManager.findCloseAnnounces(attuale);
            map.put("closeAnnounces", announces);
        } 
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not recognized action");
            return;
        }
        
        if (output != null && output.equalsIgnoreCase("json")){
            request.setAttribute("data", map);
            request.getRequestDispatcher("/json").include(request, response);
        } 
        else {
            for (String s : map.keySet()){
                request.setAttribute(s, map.get(s));
            }
            request.getRequestDispatcher("/Home").forward(request, response);
        }
    }
    
    private Point2D.Float getCurrentLocation(HttpServletRequest request){
        float x, y;
        try {
            x = Float.parseFloat(request.getParameter("locx"));
            y = Float.parseFloat(request.getParameter("locy"));
        } catch (NumberFormatException e) {
            return null;
        }
        return new Point2D.Float(x, y);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
