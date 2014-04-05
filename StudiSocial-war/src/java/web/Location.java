/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.GestoreLocationLocal;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniele, oneiros
 */
@WebServlet(name = "Location", urlPatterns = {"/location"})
public class Location extends HttpServlet {

    @EJB
    private GestoreLocationLocal gestoreLocation;

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
        String action = request.getParameter("action");
        String output = request.getParameter("output");
        HashMap<String, Object> map = new HashMap<>();
        
        if (action == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must provide an action");
            return;
        } else if (action.equalsIgnoreCase("add")) {
            String type = request.getParameter("type");
            String address = request.getParameter("address");
            Point2D.Double coords = getCurrentLocation(request);
            String description = request.getParameter("description");
            gestoreLocation.addLocation(type, address, coords, description);
            map.put("output", "Gruppo aggiunto");
        } else if (action.equalsIgnoreCase("remove")) {
            gestoreLocation.removeLocation(Long.parseLong(request.getParameter("id")));
            map.put("output", "Location eliminata");
        } else if (action.equalsIgnoreCase("listAll")) {
            List<ejb.Location> loc = gestoreLocation.listAll();
            for (ejb.Location l : loc){
                System.out.println(l);
            }
            map.put("all", loc);
        } else if (action.equalsIgnoreCase("listUsers")) {
            List<ejb.Location> users = gestoreLocation.listUsers();
            map.put("users", users);
        } else if (action.equalsIgnoreCase("listGroups")) {
            List<ejb.Location> groups = gestoreLocation.listGroups();
            map.put("groups", groups);
        } else if (action.equalsIgnoreCase("listAnnounces")) {
            List<ejb.Location> announces = gestoreLocation.listAnnounce();
            map.put("announces", announces);
        } else if (action.equalsIgnoreCase("listCloseUsers")) {
            ejb.Location attuale = new ejb.Location();        
            attuale.setCoordinate(getCurrentLocation(request));        
            List<ejb.Location> users = gestoreLocation.listCloseUsers(attuale);
            map.put("closeUsers", users);
        } else if (action.equalsIgnoreCase("listCloseGroups")) {
            ejb.Location attuale = new ejb.Location();
            attuale.setCoordinate(getCurrentLocation(request));            
            List<ejb.Location> groups = gestoreLocation.listCloseGroups(attuale);
            map.put("closeGroups", groups);
        } else if (action.equalsIgnoreCase("listCloseAnnounces")) {
            ejb.Location attuale = new ejb.Location();       
            attuale.setCoordinate(getCurrentLocation(request));        
            List<ejb.Location> announces = gestoreLocation.listCloseAnnounces(attuale);
            map.put("closeAnnounces", announces);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not recognized action");
            return;
        }
        
        if (output != null && output.equalsIgnoreCase("json")){
            request.setAttribute("data", map);
            request.getRequestDispatcher("/json").include(request, response);
        } else {
            for (String s : map.keySet()){
                request.setAttribute(s, map.get(s));
            }
            request.getRequestDispatcher("/view.jsp").include(request, response);
        }
    }
    
    private Point2D.Double getCurrentLocation(HttpServletRequest request){
        double x, y;
        try {
            x = Double.parseDouble(request.getParameter("locx"));
            y = Double.parseDouble(request.getParameter("locy"));
        } catch (Exception e) {
            return null;
        }
        return new Point2D.Double(x, y);
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
