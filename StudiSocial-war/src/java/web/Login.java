/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Utente;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UtenteFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private UtenteFacadeLocal gestoreUtenti;

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
            String nome = e.get("name").getAsString();
            String idlog = e.get("id").getAsString();
            String email = e.get("email").getAsString();
            String picture = e.get("picture").getAsString()==null ? "http://graph.facebook.com/"+idlog+"/picture?type=large" : e.get("picture").getAsString();
            
            session.setAttribute("idUtente", idlog);
            
            response.setContentType("text/html;charset=UTF-8");
            //PrintWriter out = response.getWriter();
            Utente fromIdlog = gestoreUtenti.findByIdlog(idlog);
            Utente fromEmail = gestoreUtenti.findByEmail(email);
            if (fromIdlog != null || fromEmail  != null) {

                // Metto in sessione l'utente corrente
                currentUser = fromIdlog == null ? fromEmail : fromIdlog;
                
                session.setAttribute("utente", currentUser);
                response.sendRedirect("Home");
            } else {
                
                String ua = request.getHeader("User-Agent");
                if (ua.contains("mobileSocialStudy")) {
                    request.getSession().setAttribute("mobile", true);
                }
                
                request.setAttribute("email", email);
                request.setAttribute("nome", nome.split(" ")[0]);
                request.setAttribute("cognome", nome.split(" ")[1]);
                request.setAttribute("picture", picture);
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
