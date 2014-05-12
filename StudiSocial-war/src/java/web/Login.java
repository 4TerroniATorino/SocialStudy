/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Corso;
import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;
import session.CorsoFacadeLocal;
import session.LibrettoFacadeLocal;
import session.UtenteFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private UtenteFacadeLocal gestoreUtenti;
    @EJB
    private CorsoFacadeLocal gestoreCorso;
    @EJB
    private LibrettoFacadeLocal gestoreLibretto;

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
        
        // controllo se l'utente è già registrato
        // prendi json
        
        ServletContext cxt = getServletContext();
        HttpSession session = request.getSession();
        String data = request.getParameter("data");
        Utente currentUser;
        if (session.getAttribute("utente") != null) {
            currentUser = (Utente) session.getAttribute("utente"); //???? Quest'assegnazione non fa nulla
        }
        if (data != null) {
            Gson gson = new Gson(); //???? Questa variabile non è usata
            JsonObject e = new JsonParser().parse(data).getAsJsonObject();
            session.setAttribute("idUtente", e.get("id").getAsString());
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (gestoreUtenti.find(e.get("id").getAsString()) != null
                    || gestoreUtenti.getUserByEmail(e.get("email").getAsString()) != null) {

                // Metto in sessione l'utente corrente
                currentUser = gestoreUtenti.find(e.get("id").getAsString()) == null
                        ? gestoreUtenti.getUserByEmail(e.get("email").getAsString())
                        : gestoreUtenti.find(e.get("id").getAsString());
                session.setAttribute("utente", currentUser);
               

                response.sendRedirect("Home");
            } else {

                request.setAttribute("email", e.get("email").getAsString());
                request.setAttribute("nome", e.get("name").getAsString().split(" ")[0]);
                request.setAttribute("cognome", e.get("name").getAsString().split(" ")[1]);
                RequestDispatcher rd = cxt.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
                //out.println(data); //Stampa il Json restituito dal Login in Python
            }
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
