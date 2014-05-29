package web;

import entity.Location;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.LocationFacadeLocal;

@WebServlet(name = "Locations", urlPatterns = {"/Locations"})
public class Locations extends HttpServlet {

    @EJB
    private LocationFacadeLocal gestoreLocation;

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
            Location loc = gestoreLocation.find(Long.parseLong(id));
            request.setAttribute("location", loc);
            request.setAttribute("page", "location");
        } else {
            List<entity.Location> locations1 = this.gestoreLocation.findFiltered(LocationFacadeLocal.TYPE_DEPARTMENT);
            List<entity.Location> locations2 = this.gestoreLocation.findFiltered(LocationFacadeLocal.TYPE_STUDY_HALL);
            List<entity.Location> locations3 = this.gestoreLocation.findFiltered(LocationFacadeLocal.TYPE_LIBRARY);
            request.setAttribute("locations1", locations1);
            request.setAttribute("locations2", locations2);
            request.setAttribute("locations3", locations3);
            request.setAttribute("page", "locations");
        }
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
