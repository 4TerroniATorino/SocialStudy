/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.mobile;

import entity.Messages;
import entity.PhoneNumbers;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.MessagesFacadeLocal;
import session.PhoneNumbersFacadeLocal;
import static web.mobile.MobileRegister.pregMatch;
import web.utils.MobileResponse;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

/**
 *
 * @author fase
 */
@WebServlet(name = "MobileSend", urlPatterns = {"/MobileSend"})
public class MobileSend extends HttpServlet {

    final String pattern_phNumber = "^[0-9\\-\\+]{9,15}$";
    final String pattern_devId = "/^\\S{5,255}$/";

    @EJB
    private PhoneNumbersFacadeLocal phoneNumberFacade;
    @EJB
    private MessagesFacadeLocal messagesFacade;

    private static final String GOOGLE_SERVER_KEY = "AIzaSyDq-8Oh4wFvSYYI5e4PYpFz2lyCRkXpEc4";
    private static final String MESSAGE_KEY = "message";

    /*
     public MobileSend() {
     super();
     }
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     * db -> 3 sender_invalid -> 0 recipient_invalid -> 4 success -> ?
     *
     * Da ServerProxy.java: response.code == 4 recipientException response.code
     * != 0 errore server
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String priv_key = request.getParameter("private_key");
        String phone_number = request.getParameter("phone_number");
        String recipient = request.getParameter("recipient");
        String message = request.getParameter("message");
        String output = null;
        String regId = null;

        if (priv_key == null) {
            output = "priv_key";
        } else if (phone_number == null || !pregMatch(pattern_phNumber, phone_number)) {
            output = "phone_number";
        } else if (recipient == null || !pregMatch(pattern_phNumber, phone_number)) {
            output = "recipient";
        } else if (message == null || message.isEmpty() || message.length() > 1000) {
            output = "msg-length";
        } else {

            try {

                //controlla mittente e destinatario
                PhoneNumbers senderPN = phoneNumberFacade.find(phone_number);
                PhoneNumbers recipientPN = phoneNumberFacade.find(recipient);

                if (senderPN == null) {
                    output = "sender_invalid";

                } else if (recipientPN == null) {
                    output = "recipient_invalid";

                } else {

                    //salva il msg nel db e memorizza l'id del msg
                    Messages m = new Messages();
                    m.setMessage(message);
                    m.setRecipient(recipientPN);
                    m.setSender(senderPN);
                    m.setTsSent(new Date());
                    messagesFacade.create(m);

                    //altrimenti estrai info: SELECT `device_type`, `device_id` FROM `phone_numbers` WHERE `phone_number
                    //a seconda del device invia push notif  ----> (RESTful service?)
                    output = "success";
                    
                    regId = recipientPN.getDeviceId();


                }
            } catch (Exception e) {
                output = "db";
                System.err.println(e);
            }

            try {
                // Put your Google API Server Key here

                Result result = null;

                // GCM RegId of Android device to send push notification
                //String regId = priv_key;
                //request.setAttribute("pushStatus", "GCM RegId Received.(priv_key)");
                //request.getRequestDispatcher("index.jsp").forward(request, response);

                Sender sender = new Sender(GOOGLE_SERVER_KEY);
                Message messageGcm = new Message.Builder().timeToLive(30)
                        .delayWhileIdle(true).addData(MESSAGE_KEY, message).build();

                System.out.println("regId: " + regId);

                result = sender.send(messageGcm, regId, 1);
                request.setAttribute("pushStatus", result.toString());


            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("pushStatus", e.toString());
            }

        //request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        Map map = MobileResponse.createResponse(output, null);
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
