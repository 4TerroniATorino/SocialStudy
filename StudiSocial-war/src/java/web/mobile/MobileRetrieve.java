/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.mobile;

import entity.Messages;
import entity.PhoneNumbers;
import java.io.IOException;
import java.util.List;
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

//        String priv_key = request.getParameter("private_key");
//        String phone_number = request.getParameter("phone_number"); //richiedente
        
        String priv_key = "bb91c962-3425-4db2-aa51-a886a0d5";
        String phone_number = "+393392726676";
        
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

                    //segna come letti
                    for (Messages m : messages) {
                        messagesFacade.remove(m);
                    }

                    //invia msg in json
                    output = "success";
                    Map map = MobileResponse.createResponse(output, messages);
                    request.setAttribute("data", output);
                    request.getRequestDispatcher("/json").include(request, response);
                    return;

                } else {
                    output = "unregistered";
                }

            } catch (Exception e) {
                output = "db";
                e.printStackTrace();
            }

        }

        Map map = MobileResponse.createResponse(output);
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

}
