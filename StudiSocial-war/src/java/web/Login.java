/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ejb.Corso;
import ejb.GestoreCorso;
import ejb.GestoreLibretto;
import ejb.GestoreUtenti;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author Daniele
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private GestoreUtenti gestoreUtenti;
    private GestoreCorso gestoreCorso;
    private GestoreLibretto gestoreLibretto;

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
        String data = request.getParameter("data");
        if (data != null) {
            Gson gson = new Gson();
            JsonObject e = new JsonParser().parse(data).getAsJsonObject();
            session.setAttribute("idUtente", e.get("id").getAsString());
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (gestoreUtenti.getUser(e.get("id").getAsString()) != null) {
                RequestDispatcher rd = cxt.getRequestDispatcher("/profile.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("nome", e.get("name").getAsString().split(" ")[0]);
                request.setAttribute("cognome", e.get("name").getAsString().split(" ")[1]);
                RequestDispatcher rd = cxt.getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
            }
        }

        if (op != null) {
            if (op.equalsIgnoreCase("reg")) {
                gestoreUtenti.addUser((String)session.getAttribute("idUtente"), request.getParameter("nome"),
                        request.getParameter("cognome"), request.getParameter("username"),
                        request.getParameter("email"), request.getParameter("password"));
                RequestDispatcher rd = cxt.getRequestDispatcher("/profile.jsp");
                rd.forward(request, response);
            }
            if(op.equalsIgnoreCase("crealibretto")) {
                List<Corso> l = gestoreCorso.listCorsi();
                Corso [] corsi = (Corso[]) l.toArray();
                String [] nomi = new String [corsi.length];
                for (int i = 0; i<nomi.length; i++)
                    nomi[i] = corsi[i].getNome();
                request.setAttribute("elenco", nomi);
                RequestDispatcher rd = cxt.getRequestDispatcher("/carriera.jsp");
                rd.forward(request, response);
            }
            if(op.equalsIgnoreCase("riempilibretto")) {
                String corsodistudi = request.getParameter("corsodistudi");
                String checkboxValues = request.getParameter("corso");
                String [] nomi = checkboxValues.split(",");
                Corso [] corsi = new Corso [nomi.length];
                for (int i = 0; i<nomi.length; i++)
                    corsi[i]=gestoreCorso.getCorso(nomi[i]);
                int [] voti = new int [nomi.length];
                gestoreLibretto.createLibretto((Long)session.getAttribute("idUtente"), corsodistudi, corsi, voti);
                RequestDispatcher rd = cxt.getRequestDispatcher("/profile.jsp");
                rd.forward(request, response);
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
