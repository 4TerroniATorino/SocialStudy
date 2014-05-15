/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Corso;
import entity.Utente;
import entity.Voto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CorsoFacadeLocal;
import session.VotoFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Career", urlPatterns = {"/Career"})
public class Career extends HttpServlet {

    @EJB
    private VotoFacadeLocal gestoreLibretto;
    @EJB
    private CorsoFacadeLocal gestoreCorso;

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
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("crealibretto")) {
            List<Corso> corsi = gestoreCorso.findAll();
            List<String> corsodistudi = new ArrayList();
            for (Corso c : corsi) {
                String corsost = c.getCorsodistudi();
                if (!corsodistudi.contains(corsost)) {
                    corsodistudi.add(corsost);
                }
            }
            request.setAttribute("corsi", corsi);
            request.setAttribute("corsiDiStudi", corsodistudi);
            request.setAttribute("page", "career");
            request.getRequestDispatcher("/Home").forward(request, response);
        } else if (action.equalsIgnoreCase("riempilibretto")) {
            String[] checkboxValues = request.getParameterValues("corsiselezionati");
            Utente currentUser = (Utente) request.getSession().getAttribute("utente");
            for (String checkboxValue : checkboxValues) {
                Corso corso = gestoreCorso.find(Long.parseLong(checkboxValue));
                Voto voto = new Voto();
                voto.setCorso(corso.getId());
                voto.setIdUtente(currentUser.getId());
                voto.setVoti((short) 0);
                gestoreLibretto.create(voto);
            }
            response.sendRedirect("Users?id=" + currentUser.getId());
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
