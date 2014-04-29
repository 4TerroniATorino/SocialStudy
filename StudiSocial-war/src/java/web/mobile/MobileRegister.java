/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.mobile;

import entity.PhoneNumbers;
import entity.Utente;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.PhoneNumbersFacadeLocal;
import session.UtenteFacadeLocal;
import web.utils.MobileResponse;

/**
 *
 * @author Gianvito
 *
 * Servlet per la registrazione da device mobile:
 * 
 *    reqParam: email, phone_number, device_type, device_id
 * 
 *    la servlet controlla:
 *    -  se i parametri sono corretti,
 *    -  se l'utente è già loggato (tramite fb/g)
 *    -  quindi aggiorna o aggiunge nel db: in caso di aggiunta bisgona richiamare 
 *         la procedura di login per gli altri dati
 *    -  infine invia la response con: 
 *         0, 'phone number registered'
 *         1, 'errore nei parametri'
 *         3, 'errore internocol DB'
 *         5, 'errore utente non registrato' (nota: client reindirizza alla registrazione)
 *  
 * 
 */
@WebServlet(name = "MobileRegister", urlPatterns = {"/MobileRegister"})
public class MobileRegister extends HttpServlet {

    @EJB private PhoneNumbersFacadeLocal phoneNumberFacade;
    @EJB private UtenteFacadeLocal utenteFacade;
    
    final String pattern_phNumber = "/^\\+\\d{5,19}$/";
    final String pattern_devId = "/^\\S{5,255}$/";
    
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String device_type = request.getParameter("device_type");
        String device_id = request.getParameter("device_id");
        String output = null;
        
        if(email==null){
            output = "email";
        } else if (phone_number==null || !pregMatch(pattern_phNumber, phone_number)){
            output = "phone_number";
        } else if (device_type==null || !device_type.equalsIgnoreCase("Android") || !device_type.equalsIgnoreCase("iOS") ){
            output = "device_type";
        } else if (device_id==null || pregMatch(pattern_devId, phone_number)){
            output = "device_id";
        } else {
            
            //controlla la mail nel db: si->loggato, no->errore
            Utente utente = null;
            try{
                utente = utenteFacade.getUserByEmail(email);
            }catch(Exception e){
                output = "user";
                System.err.println(e);
            }
            
            
            if (utente != null){
                try {
                    
                    //controlla phone_number nel db: si->update, no->add
                    String number = utente.getPhoneNumber();
                    PhoneNumbers phoneNumber = phoneNumberFacade.find(number);

                    //salva nel DB e aggancia all'utente *********(tabelle/ejb: messages e phone_numbers)
                    if (phoneNumber != null){
                        phoneNumber.setDeviceId(device_id);
                        phoneNumber.setDeviceType(device_type);
                        phoneNumberFacade.edit(phoneNumber);
                    } else {
                        phoneNumber = new PhoneNumbers(phone_number);
                        phoneNumber.setDeviceId(device_id);
                        phoneNumber.setDeviceType(device_type);
                        //phoneNumber.setPrivateKey(UUID.randomUUID()); //genera una key per la entry nel db
                        phoneNumberFacade.create(phoneNumber);
                    }

                    output = "registered";
                    
                } catch (Exception e){
                    output = "db";
                    System.err.println(e);
                }
                
            }
            
            //!logged: richiama la procedura di login e completa la registrazione
            else {
                output = "unregistered";
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
