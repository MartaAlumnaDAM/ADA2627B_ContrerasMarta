package app;
import clases.IA;
import clases.Portales;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.JacksonMapper;

public class IA_JSON_a_XML {

    public static void main(String[] args) {

        // **************************************
        // JSON - Leer 
        String archivo = "./datos/iartificial.json";
        
        ArrayList<IA> listaIA = new ArrayList<>();
        
        String jsonList = "";
        
        jsonList = JacksonMapper.jsonMapperWriter(listaIA);
                
        System.out.println(jsonList);
        
        // **************************************
        // Mapeo
        //Portales portales = new Portales();
       
        // **************************************
        // XML - Escribir 
        //String xmlPortales = "";

        //System.out.println(xmlPortales);
        
        
        
    }
    
    
    
}
