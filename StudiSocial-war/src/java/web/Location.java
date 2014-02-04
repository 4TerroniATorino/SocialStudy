/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.GestoreLocation;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Location", urlPatterns = {"/Location"})
public class Location extends HttpServlet {

    @EJB
    private GestoreLocation gestoreLocation;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext cxt = getServletContext();
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            Long id = Long.parseLong(request.getParameter("ID"));
            String type = request.getParameter("type");
            String address = request.getParameter("address");
            //Point2D coordinate = request.getParameter("coordinate");
            String description = request.getParameter("description");
            //gestoreLocation.addLocation(id, type, address, coordinate, description);
            request.setAttribute("elenco", "Gruppo aggiunto");
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("remove")) {
            gestoreLocation.removeLocation(Long.parseLong(request.getParameter("id")));
            request.setAttribute("elenco", "Location eliminata");
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listAll")) {
            List<ejb.Location> loc = gestoreLocation.listAll();
            request.setAttribute("elenco", loc);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listUsers")) {
            List<ejb.Location> users = gestoreLocation.listUsers();
            request.setAttribute("elenco", users);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listGroups")) {
            List<ejb.Location> groups = gestoreLocation.listGroups();
            request.setAttribute("elenco", groups);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listAnnounces")) {
            List<ejb.Location> announces = gestoreLocation.listAnnounce();
            request.setAttribute("elenco", announces);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listCloseUsers")) {
            //List<ejb.Location> users = gestoreLocation.listCloseUsers(request.getParameter("posizione attuale"));
            //request.setAttribute("elenco", users);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listCloseGroups")) {
            //List<ejb.Location> groups = gestoreLocation.listCloseGroups(request.getParameter("posizione attuale"));
            //request.setAttribute("elenco", groups);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listCloseAnnounces")) {
            //List<ejb.Location> announces = gestoreLocation.listCloseAnnounces(request.getParameter("posizione attuale"));
            //request.setAttribute("elenco", announces);
            RequestDispatcher rd = cxt.getRequestDispatcher("/visualizza.jsp");
            rd.forward(request, response);
        }
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
