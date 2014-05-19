/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Gruppo;
import entity.Utente;
import entity.Voto;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String id = request.getParameter("id");
        if (id != null) {
            Utente user = findUtente(id);
            List<Voto> voti = gestoreLibretto.findByUser(user);
            //List<Gruppo> gruppi = gestoreGruppo.fi; TODO
            request.setAttribute("user", user);
            request.setAttribute("libretto", voti);
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

    private Utente findUtente(String id) {
        List<Utente> list = gestoreUtente.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(Long.parseLong(id))) {
                return list.get(i);
            }
        }
        return null;
    }

}
