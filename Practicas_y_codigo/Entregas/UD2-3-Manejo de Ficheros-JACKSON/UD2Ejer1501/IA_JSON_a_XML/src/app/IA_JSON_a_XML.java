
package app;

import clases.IA;
import clases.Portales;
import java.util.ArrayList;
import utils.JacksonMapper;


public class IA_JSON_a_XML {

    public static void main(String[] args) {

        // **************************************
        // JSON - Leer 
        String archivo = "./datos/iartificial.json";
        String jsonList = JacksonMapper.readFromFileDirect(archivo);
        System.out.println("---- Lectura del archivo desde string ----");
        System.out.println(jsonList);
        
        // **************************************
        // Mapeo
        
        ArrayList<IA> listaIAs = JacksonMapper.jsonArrayMapperReader(jsonList, IA.class);
        Portales portales = new Portales();
       
        portales.setPortales(listaIAs);
        
        // **************************************
        // XML - Escribir 
        String xmlPortales = JacksonMapper.xmlMapperWriter(portales);

        JacksonMapper.writeToFile("./datos/portalesia.xml", xmlPortales);
        
        System.out.println("---- Lectura del xml ----");
        System.out.println(xmlPortales);
        
        
        
    }
    
    
    
}
