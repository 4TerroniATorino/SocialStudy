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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CorsoFacadeLocal;
import session.GruppoFacadeLocal;
import session.IncontroFacadeLocal;
import session.UtenteFacadeLocal;
import session.VotoFacadeLocal;

/**
 *
 * @author Daniele
 */
@WebServlet(name = "Groups", urlPatterns = {"/Groups"})
public class Groups extends HttpServlet {

    @EJB private GruppoFacadeLocal gestoreGruppo;
    @EJB private IncontroFacadeLocal gestoreIncontro;
    @EJB private CorsoFacadeLocal gestoreCorso;
    @EJB private UtenteFacadeLocal gestoreUtente;
    @EJB private VotoFacadeLocal gestoreLibretto;

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
        
        Utente currentUser = (Utente) request.getSession().getAttribute("utente");
        
        String action = request.getParameter("action");
        String output = request.getParameter("output");
        HashMap<String, Object> map = new HashMap<>();

        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must provide an action");
            return;
        } else if (action.equalsIgnoreCase("show")) {
            String id = request.getParameter("id");
            if (id != null) {
                Gruppo gruppo = gestoreGruppo.find(Long.parseLong(id));
                map.put("gruppo", gruppo);
                int adminLevel = 0;
                if (gruppo.getFondatore().equals(currentUser)){
                    adminLevel = 2;
                } else if (gruppo.getUtenteCollection().contains(currentUser)){
                    adminLevel = 1;
                }
                map.put("adminLevel", adminLevel);
                map.put("page", "group");
            } else {
                List<Gruppo> gruppi = gestoreGruppo.findAll();
                map.put("gruppi", gruppi);
                map.put("page", "groups");
            }
        } else if (action.equalsIgnoreCase("createGroup")) {
            List<Voto> voti = gestoreLibretto.findByUser(currentUser);
            List<Corso> corsi = new ArrayList();
            for (Voto v : voti) {
                corsi.add(v.getCorso());
            }
            map.put("libretto", corsi);
            map.put("page", "group_create");
        } else if (action.equalsIgnoreCase("addGroup")) {
            Gruppo gr = new Gruppo();
            gr.setNome(request.getParameter("nome"));
            gr.setArgomenti(request.getParameter("argomenti"));
            long corso = Long.parseLong(request.getParameter("corso"));
            if (corso != -1)
                gr.setCorso(gestoreCorso.find(corso));
            gr.setFondatore(currentUser);
            gestoreGruppo.create(gr);
            response.sendRedirect("Groups?action=show&id="+gr.getId());
        } else if (action.equalsIgnoreCase("removeGroup")) {
            Gruppo gr = gestoreGruppo.find(Long.parseLong(request.getParameter("id")));
            gestoreGruppo.remove(gr);
            map.put("output", "Gruppo cancellato");
        } else if (action.equalsIgnoreCase("addUser")) {
            //gestoreGruppo.addUser(Long.parseLong(request.getParameter("groupid")), Long.parseLong(request.getParameter("userid")));
            map.put("output", "Utente aggiunto");
        } else if (action.equalsIgnoreCase("removeUser")) {
            //gestoreGruppo.removeUser(Long.parseLong(request.getParameter("groupid")), Long.parseLong(request.getParameter("userid")));
            map.put("output", "Utente rimosso");
        } else if (action.equalsIgnoreCase("list")) {
            List<Gruppo> gruppi = gestoreGruppo.findAll();
            map.put("groups", gruppi);
        }  else {
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
            request.getRequestDispatcher("/Home").forward(request, response);
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
