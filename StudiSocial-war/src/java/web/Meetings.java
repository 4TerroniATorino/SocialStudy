/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import entity.Incontro;
import entity.Location;
import entity.Utente;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.GruppoFacadeLocal;
import session.IncontroFacadeLocal;
import session.LocationFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Meetings", urlPatterns = {"/Meetings"})
public class Meetings extends HttpServlet {

    @EJB
    private IncontroFacadeLocal gestoreIncontri;
    @EJB
    private GruppoFacadeLocal gestoreGruppi;
    @EJB
    private LocationFacadeLocal gestoreLocation;
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
        
        Utente currentUser = (Utente) request.getSession().getAttribute("utente");
        
        String action = request.getParameter("action");
        
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must provide an action");
            return;
        }


        else if (action.equalsIgnoreCase("show")) {
            String idIncontro = request.getParameter("idIncontro");
            if(idIncontro!=null) {
                Incontro incontro = gestoreIncontri.find(idIncontro);
                request.setAttribute("incontro", incontro);
            }
            else {
                List<Incontro> incontri = gestoreIncontri.findAll();
                request.setAttribute("incontri", incontri);
            }
            request.setAttribute("page", "meetings");

        }
        
        else if (action.equalsIgnoreCase("createMeeting")) {
            
            List<Location> locations = gestoreLocation.findAll();
            
            request.setAttribute("idGruppo", request.getParameter("idGruppo"));
            request.setAttribute("locations", locations);

                        request.setAttribute("page", "meeting_create");

        
        }
        
        else if (action.equalsIgnoreCase("modMeeting")) {
            String id = request.getParameter("id");
            Incontro inc = gestoreIncontri.find(id);
            //inc.setDataincontro(request.getParameter("date"));
            //inc.setLocationId(request.getParameter("locId"));
                    request.setAttribute("page", "meetings");

        }
        
        else if (action.equalsIgnoreCase("delMeeting")) {
            String id = request.getParameter("id");
            gestoreIncontri.remove(gestoreIncontri.find(id));
                    request.setAttribute("page", "meetings");

        }
        
        else if (action.equalsIgnoreCase("addMeeting")){
            Incontro newIncontro = new Incontro();
            
            /*newIncontro.setDataincontro(request.getParameter("data"));
            newIncontro.setGruppoId(request.getParameter("idGruppo"));
            newIncontro.setLocationId(request.getParameter("location"));
            newIncontro.setArgomento(request.getParameter("argomento"));*/
            
            gestoreIncontri.create(newIncontro);
                    request.setAttribute("page", "meetings");

        }
        
        request.getRequestDispatcher("/Home").forward(request, response);
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
