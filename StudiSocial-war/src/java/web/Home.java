package web;

import entity.Gruppo;
import entity.Utente;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.GruppoFacadeLocal;
import session.LocationFacadeLocal;
import session.UtenteFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    @EJB
    private UtenteFacadeLocal usersManager;
    @EJB
    private GruppoFacadeLocal groupsManager;
    @EJB
    private LocationFacadeLocal locationsManager;

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
        response.setContentType("text/html;charset=UTF-8");

        // controllo se l'utente è mobile o desktop
        String ua = request.getHeader("User-Agent");
        if (ua.contains("mobileSocialStudy")) {
            request.getSession().setAttribute("mobile", true);
        }

        // controllo se l'utente è già loggato (sessione aperta)
        Utente currentUser = (Utente) request.getSession().getAttribute("utente");
        if (currentUser == null) {
            request.getRequestDispatcher("/login.jsp").include(request, response);
        } else {
            List<Utente> users = this.usersManager.findAll();
            request.setAttribute("users", users);
            List<Gruppo> groups = this.groupsManager.findAll();
            request.setAttribute("groups", groups);
            List<entity.Location> locations1 = this.locationsManager.findFiltered(LocationFacadeLocal.TYPE_DEPARTMENT);
            List<entity.Location> locations2 = this.locationsManager.findFiltered(LocationFacadeLocal.TYPE_STUDY_HALL);
            List<entity.Location> locations3 = this.locationsManager.findFiltered(LocationFacadeLocal.TYPE_LIBRARY);
            request.setAttribute("locations1", locations1);
            request.setAttribute("locations2", locations2);
            request.setAttribute("locations3", locations3);
            if (request.getAttribute("page") == null) {
                request.setAttribute("page", "news");
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
