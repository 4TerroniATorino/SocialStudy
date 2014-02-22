/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.Corso;
import ejb.GestoreCorsoLocal;
import ejb.GestoreGruppoLocal;
import ejb.GestoreIncontroLocal;
import ejb.GestoreLocationLocal;
import ejb.GestoreUtentiLocal;
import ejb.Gruppo;
import ejb.Incontro;
import ejb.Utente;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
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
 * @author Daniele
 */
@WebServlet(name = "Groups", urlPatterns = {"/Groups"})
public class Groups extends HttpServlet {

    @EJB
    private GestoreUtentiLocal gestoreUsers;
    @EJB
    private GestoreGruppoLocal gestoreGruppo;
    @EJB
    private GestoreIncontroLocal gestoreIncontro;
    @EJB
    private GestoreLocationLocal gestoreLocation;
    @EJB
    private GestoreCorsoLocal gestoreCorso;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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

        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must provide an action");
            return;
        } else if (action.equalsIgnoreCase("addGroup")) {
            String nome = request.getParameter("nome");
            Utente user = gestoreUsers.getUser(request.getParameter("idUser"));
            String args = request.getParameter("argomenti");
            Corso corso = gestoreCorso.getCorso(Long.parseLong(request.getParameter("idCorso")));
            gestoreGruppo.addGruppo(nome, user, args, corso);
            map.put("output", "Gruppo aggiunto");
        } else if (action.equalsIgnoreCase("removeGroup")) {
            gestoreGruppo.removeGruppo(Long.parseLong(request.getParameter("id")));
            map.put("output", "Gruppo cancellato");
        } else if (action.equalsIgnoreCase("list")) {
            System.out.println("LALALA" + gestoreGruppo);
            List<Gruppo> gruppi = gestoreGruppo.listGruppi();
            map.put("groups", gruppi);
        } else if (action.equalsIgnoreCase("addIncontro")) {
            Gruppo gruppo = gestoreGruppo.getGruppo(Long.parseLong(request.getParameter("idGruppo")));
            ejb.Location location = gestoreLocation.getLocation(Long.parseLong(request.getParameter("idLocation")));
            Date date = parseDate(request.getParameter("data"));
            gestoreIncontro.addIncontro(gruppo, location, date);
            map.put("output", "Incontro creato");
        } else if (action.equalsIgnoreCase("removeIncontro")) {
            gestoreIncontro.removeIncontro(Long.parseLong(request.getParameter("id")));
            map.put("output", "Incontro eliminato");
        } else if (action.equalsIgnoreCase("listIncontri")) {
            List<Incontro> incontri = gestoreIncontro.listIncontri();
            map.put("incontri", incontri);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not recognized action");
            return;
        }

        if (output != null && output.equalsIgnoreCase("json")) {
            request.setAttribute("data", map);
            request.getRequestDispatcher("/json").include(request, response);
        } else {
            for (String s : map.keySet()) {
                request.setAttribute(s, map.get(s));
            }
            request.getRequestDispatcher("/view.jsp").include(request, response);
        }

    }

    private Date parseDate(String s) {
        Date d = null;
        try {
            d = new Date(new SimpleDateFormat("dd/MM/yyyy").parse(s).getTime());
        } catch (ParseException ex) {
        }
        return d;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
