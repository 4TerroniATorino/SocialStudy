/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.mobile;

import entity.Messages;
import entity.PhoneNumbers;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.MessagesFacadeLocal;
import session.PhoneNumbersFacadeLocal;
import web.utils.MobileResponse;

/**
 *
 * @author fase
 */
@WebServlet(name = "MobileRetrieve", urlPatterns = {"/MobileRetrieve"})
public class MobileRetrieve extends HttpServlet {

    private static final SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
    final String pattern_phNumber = "^[0-9\\-\\+]{9,15}$";

    @EJB
    private PhoneNumbersFacadeLocal phoneNumberFacade;
    @EJB
    private MessagesFacadeLocal messagesFacade;

    public static boolean pregMatch(String pattern, String content) {
        return content.matches(pattern);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     *
     * unregistered : error invalid phone number -> response = 2 success : da
     * vedere nell app DB -> response = 0
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String priv_key = request.getParameter("private_key");
        String phone_number = request.getParameter("phone_number"); //richiedente

        HashMap result = new HashMap();
        String output;

        if (priv_key == null) {
            output = "priv_key";
        } else if (phone_number == null || !pregMatch(pattern_phNumber, phone_number)) {
            output = "phone_number";
        } else {

            try {

                //controlla richiedente
                PhoneNumbers phoneNumber = phoneNumberFacade.find(phone_number);

                if (phoneNumber != null) {

                    //cerca i msg nel db e restituisci un array
                    List<Messages> messages = messagesFacade.findAllByRecipient(phoneNumber);

                    List<JsonMessage> jsonMessages = new ArrayList();

                    for (Messages m : messages) {

                        //System.out.println(m.getMessage()+" "+m.getIsRead());
                        //if(!m.getIsRead()){
                        //creiamo un jsonMessage
                            JsonMessage jm = new JsonMessage();
                            jm.id = m.getId().toString();
                            jm.message = m.getMessage();
                            jm.recipient = m.getRecipient().getPhoneNumber();
                            jm.sender = m.getSender().getPhoneNumber();
                            jm.ts_sent = DATEFORMATTER.format(m.getTsSent());

                            jsonMessages.add(jm);
                            //segna come letti
                            messagesFacade.remove(m);
                            //m.setIsRead(Boolean.TRUE);
                            //messagesFacade.edit(m);
                        //}
                    }

                    //invia msg in json
                    output = "success";
                    result.put("messages", jsonMessages);

                } else {
                    output = "unregistered";
                }

            } catch (Exception e) {
                output = "db";
                e.printStackTrace();
            }

        }

        Map map = MobileResponse.createResponse(output, result);
        request.setAttribute("data", map);
        request.getRequestDispatcher("/json").include(request, response);

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

    private static class JsonMessage {

        public String id;
        public String sender;
        public String recipient;
        public String message;
        public String ts_sent;
    }
}
