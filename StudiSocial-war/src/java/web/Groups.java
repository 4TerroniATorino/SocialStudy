/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.Corso;
import ejb.GestoreCorso;
import ejb.GestoreGruppo;
import ejb.GestoreIncontro;
import ejb.GestoreLocation;
import ejb.GestoreUsers;
import ejb.Gruppo;
import ejb.Incontro;
import ejb.User;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "Groups", urlPatterns = {"/Groups"})
public class Groups extends HttpServlet {

    @EJB
    private GestoreUsers gestoreUsers;
    private GestoreGruppo gestoreGruppo;
    private GestoreIncontro gestoreIncontro;
    private GestoreLocation gestoreLocation;
    private GestoreCorso gestoreCorso;

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
        if (action.equalsIgnoreCase("addGroup")) {
            Long id = Long.parseLong(request.getParameter("ID"));
            String nome = request.getParameter("nome");
            User user = gestoreUsers.getUser(Long.parseLong(request.getParameter("userID")));
            // String[] args = request.getParameter("argomenti");
            Corso corso = gestoreCorso.getCorso(Long.parseLong(request.getParameter("corso")));
            // gestoreGruppo.addGruppo(id, nome, user, args, corso);
            request.setAttribute("elenco", "Gruppo aggiunto");
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("removeGroup")) {
            gestoreGruppo.removeGruppo(Long.parseLong(request.getParameter("id")));
            request.setAttribute("elenco", "Gruppo cancellato");
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listGroups")) {
            List<Gruppo> gruppi = gestoreGruppo.listGruppi();
            request.setAttribute("elenco", gruppi);
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("addIncontro")) {
            Long id = Long.parseLong(request.getParameter("ID"));
            Gruppo gruppo = gestoreGruppo.getGruppo(Long.parseLong(request.getParameter("idGruppo")));
            ejb.Location location = gestoreLocation.getLocation(Long.parseLong(request.getParameter("idLocation")));
            //Date data = request.getParameter("data");
            //gestoreIncontro.addIncontro(id, gruppo, location, data);
            request.setAttribute("elenco", "Incontro creato");
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("removeIncontro")) {
            gestoreIncontro.removeIncontro(Long.parseLong(request.getParameter("id")));
            request.setAttribute("elenco", "Incontro eliminato");
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
            rd.forward(request, response);
        }
        if (action.equalsIgnoreCase("listIncontri")) {
            List<Incontro> incontri = gestoreIncontro.listIncontri();
            request.setAttribute("elenco", incontri);
            RequestDispatcher rd = cxt.getRequestDispatcher("/Visualizza.jsp");
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