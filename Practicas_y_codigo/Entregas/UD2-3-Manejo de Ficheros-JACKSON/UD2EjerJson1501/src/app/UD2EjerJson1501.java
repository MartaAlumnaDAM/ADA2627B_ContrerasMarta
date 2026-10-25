package app;

import clases.IA;
import clases.Portales;
import java.util.ArrayList;
import utils.JacksonMapper;

public class UD2EjerJson1501 {

    public static void main(String[] args) {
        // **************************************
        // JSON - Leer 
        String jsonList = JacksonMapper.readFromFileDirect("./datos/iartificial.json");
                
        System.out.println(jsonList);
        
        // **************************************
        // Mapeo
        Portales portales = new Portales();
        
        ArrayList<IA> listaIAs = new ArrayList<>();
        portales.setPortales(listaIAs);
       
        // **************************************
        // XML - Escribir 
        String xmlPortales = "";
        
        

        System.out.println(xmlPortales);
    }
    
}
