/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import entity.Incontro;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        ServletContext cxt = getServletContext();
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        if (op.equalsIgnoreCase("show")) {
            String id = request.getParameter("id");
            Incontro inc = gestoreIncontri.find(id);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date) inc.getDataincontro();
            String out = df.format(date)+"\n";
            out += gestoreGruppi.find(inc.getGruppoId()).getNome()+"\n";
            out += gestoreLocation.find(inc.getLocationId()).getDescrizione();
            request.setAttribute("elenco", out);
            RequestDispatcher rd = cxt.getRequestDispatcher("/meetings.jsp");
            rd.forward(request, response);
        }
        else if (op.equalsIgnoreCase("modMeeting")) {
            String id = request.getParameter("id");
            Incontro inc = gestoreIncontri.find(id);
            //inc.setDataincontro(request.getParameter("date"));
            //inc.setLocationId(request.getParameter("locId"));
            RequestDispatcher rd = cxt.getRequestDispatcher("/meetings.jsp");
            rd.forward(request, response);
        }
        else if (op.equalsIgnoreCase("delMeeting")) {
            String id = request.getParameter("id");
            gestoreIncontri.remove(gestoreIncontri.find(id));
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
