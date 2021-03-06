/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Corso;
import entity.Gruppo;
import entity.Utente;
import entity.Voto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CorsoFacadeLocal;
import session.GruppoFacadeLocal;
import session.UtenteFacadeLocal;
import session.VotoFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Users", urlPatterns = {"/Users"})
public class Users extends HttpServlet {

    @EJB
    private UtenteFacadeLocal gestoreUtente;
    @EJB
    private VotoFacadeLocal gestoreLibretto;
    @EJB
    private GruppoFacadeLocal gestoreGruppo;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            Utente user = gestoreUtente.find(Long.parseLong(id));
            Collection<Voto> voti = gestoreLibretto.findByUser(user);
            Collection<Gruppo> gruppi = user.getGruppiPartecipante();
            Collection<Gruppo> gruppiFondati = gestoreGruppo.findAllByFounder(user);
            Collection<Corso> corsi = gestoreCorso.findAll();
            Collection<Corso> corsiInLibretto = new ArrayList<>();
            Collection<Corso> corsiNonInLibretto = new ArrayList<>();
            for(Voto v : voti){
                corsiInLibretto.add(v.getCorso());
            }
            for(Corso c : corsi){
                if(!corsiInLibretto.contains(c)){
                    corsiNonInLibretto.add(c);
                }
            }
            request.setAttribute("user", user);
            request.setAttribute("libretto", voti);
            request.setAttribute("gruppi", gruppi);
            request.setAttribute("corsi", corsi);
            request.setAttribute("corsiInLibretto", corsiInLibretto);
            request.setAttribute("corsiNonInLibretto", corsiNonInLibretto);
            request.setAttribute("gruppiFondati", gruppiFondati);
        } else {
            List<Utente> users = gestoreUtente.findAll();
            request.setAttribute("users", users);
        }
        request.setAttribute("page", "users");
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
