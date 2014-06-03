/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import entity.Gruppo;
import entity.Incontro;
import entity.Location;
import entity.Utente;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.GruppoFacadeLocal;
import session.IncontroFacadeLocal;
import session.LocationFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Meetings", urlPatterns = {"/Meetings"})
public class Meetings extends HttpServlet {

    @EJB
    private IncontroFacadeLocal gestoreIncontri;
    @EJB
    private GruppoFacadeLocal gestoreGruppi;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Utente currentUser = (Utente) request.getSession().getAttribute("utente");
        
        String action = request.getParameter("action");
        
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must provide an action");
            return;
        }
        /*else if (action.equalsIgnoreCase("addIncontro")) {
            Incontro incontro = new Incontro();
            incontro.setGruppoId(new BigInteger(request.getParameter("idGruppo")));
            incontro.setLocationId(new BigInteger(request.getParameter("idLocation")));
            incontro.setDataincontro(parseDate(request.getParameter("data")));
            gestoreIncontro.create(incontro);
            map.put("output", "Incontro creato");
        } else if (action.equalsIgnoreCase("removeIncontro")) {
            Incontro incontro = gestoreIncontro.find(Long.parseLong(request.getParameter("id")));
            gestoreIncontro.remove(incontro);
            map.put("output", "Incontro eliminato");
        } else if (action.equalsIgnoreCase("listIncontri")) {
            List<Incontro> incontri = gestoreIncontro.findAll();
            map.put("incontri", incontri);
        }*/


        else if (action.equalsIgnoreCase("show")) {
            String idIncontro = request.getParameter("idIncontro");
            if(idIncontro!=null) {
                Incontro incontro = gestoreIncontri.find(idIncontro);
                request.setAttribute("incontro", incontro);
            } else {
                List<Incontro> incontri = new ArrayList<>();
                Collection<Gruppo> gruppi1 = currentUser.getGruppiFondati();
                Collection<Gruppo> gruppi2 = currentUser.getGruppiPartecipante();
                for (Gruppo g : gruppi1){
                    for (Incontro i : g.getIncontri()){
                        incontri.add(i);
                    }
                }
                for (Gruppo g : gruppi2){
                    for (Incontro i : g.getIncontri()){
                        incontri.add(i);
                    }
                }
                request.setAttribute("incontri", incontri);
            }
            request.setAttribute("page", "meetings");

        }
        
        else if (action.equalsIgnoreCase("createMeeting")) {
            Long idgruppo = Long.parseLong(request.getParameter("idGruppo"));
            List<Location> locations = gestoreLocation.findAll();
            Gruppo gruppo = gestoreGruppi.find(idgruppo);
            request.setAttribute("gruppo", gruppo);
            request.setAttribute("locations", locations);

            request.setAttribute("page", "meeting_create");

        
        }
        
        else if (action.equalsIgnoreCase("modMeeting")) {
            String id = request.getParameter("id");
            String strDate = request.getParameter("data");
            
            Incontro inc = gestoreIncontri.find(id);
            
            Date date;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(strDate);
                inc.setData(date);
            } catch (ParseException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date");
                return;
            }
            //inc.setLocationId(request.getParameter("locId"));
            request.setAttribute("page", "meetings");

        }
        
        else if (action.equalsIgnoreCase("delMeeting")) {
            String id = request.getParameter("id");
            gestoreIncontri.remove(gestoreIncontri.find(id));
                    request.setAttribute("page", "meetings");

        }
        
        //richiamato da meeting_create
        else if (action.equalsIgnoreCase("addMeeting")){
            Incontro newIncontro = new Incontro();
            
            Long idgruppo = Long.parseLong(request.getParameter("idGruppo"));
            Gruppo gruppo = gestoreGruppi.find(idgruppo);
            newIncontro.setGruppo(gruppo);
            
            Long idlocation = Long.parseLong(request.getParameter("idLocation"));
            if(idlocation!=-1){
                Location loc = gestoreLocation.find(idlocation);
                newIncontro.setLocation(loc);
            }
            
            newIncontro.setArgomento(request.getParameter("argomento"));
            String strDate = request.getParameter("data");
            Date date;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(strDate);
                newIncontro.setData(date);
            } catch (ParseException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date");
                return;
            }

            
            gestoreIncontri.create(newIncontro);
            
            request.setAttribute("page", "meetings");

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
