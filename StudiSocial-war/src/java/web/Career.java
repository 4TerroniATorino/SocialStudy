/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Corso;
import entity.Libretto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CorsoFacadeLocal;
import session.LibrettoFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Career", urlPatterns = {"/Career"})
public class Career extends HttpServlet {

    @EJB
    private LibrettoFacadeLocal gestoreLibretto;
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
        ServletContext cxt = getServletContext();
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("riempilibretto")) {
            List<Corso> corsi = gestoreCorso.findAll();
            List<String> corsodistudi = new ArrayList();
            for (Corso c : corsi) {
                String corsost = c.getCorsodistudi();
                if (!corsodistudi.contains(corsost)) {
                    corsodistudi.add(corsost);
                }
            }
            String[] corsidistudi = new String[corsodistudi.size()];
            for (int i = 0; i < corsodistudi.size(); i++) {
                corsidistudi[i] = corsodistudi.get(i);
            }
            //Arrays.sort(corsidistudi);
            request.setAttribute("elenco", corsidistudi);
            RequestDispatcher rd = cxt.getRequestDispatcher("/career.jsp");
            rd.forward(request, response);
        }
        else if (action.equalsIgnoreCase("getcorsi")) {
            String corsostudi = request.getParameter("corso");
            int len = 0;
            List<Corso> corsi = gestoreCorso.findAll();
            for (Corso c : corsi) {
                len++;
            }
            String[] nomi = new String[len];
            int i = 0;
            for (Corso c : corsi) {
                if (c.getCorsodistudi().equalsIgnoreCase(corsostudi)) {
                    nomi[i] = c.getNome();
                    i++;
                }
            }
            request.setAttribute("corsi", nomi);
            String code = "<form method=\"post\" action=\"Career\">"
                    + "<% for (int i = 0; i < request.getAttribute(\"elenco\"); i++) {%>"
                    + "<input type=\"checkbox\" name=\"corso\" value=\"<%= ((String[]) request.getAttribute(\"elenco\"))[i]%>\"><br><%}%>"
                    + "<input type=\"hidden\" name=\"action\" value=\"riempilibretto\">"
                    + "<input type=\"submit\" value=\"Confema\">"
                    + "</form>";
            request.setAttribute("code", code);
        }
        else if (action.equalsIgnoreCase("riempilibretto")) {
            String checkboxValues = request.getParameter("corso");
            String[] nomi = checkboxValues.split(",");
            //Corso[] corsi = new Corso[nomi.length];
            //for (int i = 0; i < nomi.length; i++) {
            //    corsi[i] = gestoreCorso.find(nomi[i]);
            //}
            byte[] voti = new byte[nomi.length];
            Libretto libretto = new Libretto();
            libretto.setVoti(voti);
            //gestoreLibretto.createLibretto(corsi, voti); perchè i corsi sono un array di byte????
        }
        request.setAttribute("page", "career");
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
