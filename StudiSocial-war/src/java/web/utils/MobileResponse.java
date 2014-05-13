package web.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Messages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gianvito
 */
public class MobileResponse {
    
    public static Map createResponse(String output){
        HashMap map = new HashMap();
        
        if(output.equalsIgnoreCase("success") 
        || output.equalsIgnoreCase("registered")){
            map.put("code", 0);
            map.put("description", output);
        }else if(output.equalsIgnoreCase("phone_number")
                || output.equalsIgnoreCase("device_type")
                || output.equalsIgnoreCase("device_id")){
            map.put("code", 1);
            map.put("description", output+" : errore nei parametri");    
        }else if(output.equalsIgnoreCase("unregistered")){
            map.put("code", 2);
            map.put("description", output+": error invalid phone number");
        }else if(output.equalsIgnoreCase("db")){
            map.put("code", 3);
            map.put("description", output+": errore interno col DB");
        }else if(output.equalsIgnoreCase("recipient_invalid")){
            map.put("code", 4);
            map.put("description", output);
        }else if(output.equalsIgnoreCase("user"))
        {
            map.put("code", 5);
            map.put("description", output+" errore utente non registrato");
        }
        map.put("result", null);
        return map;
    }
    
    public static Map createResponse(String output, List<Messages> messages){
        Map map = createResponse(output);
        map.put("result", messages);
        return map;
    }
            
}
