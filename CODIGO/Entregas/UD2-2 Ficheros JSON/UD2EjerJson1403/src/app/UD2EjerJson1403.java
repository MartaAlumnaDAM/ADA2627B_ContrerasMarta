/*
* @author marta
A través de la URL "http://ip-api.com/json/213.0.87.123" obtenemos
diferente información de la IP 213.0.87.123, como el país, la ciudad y
el proveedor de comunicación.
Realizar aplicación que realice los siguientes procesos:
P1) Cargar el contenido en un JSONObject a Memoria
P2) Recorrer los campos del JSONObject y mostrar la clave y valor de
cada par.

 */
package app;

import java.util.Iterator;
import org.json.JSONObject;
import utils.JSONUtils;

public class UD2EjerJson1403 {

    public static void main(String[] args) {

        try {
            /* P1) Cargar el contenido en un JSONObject a Memoria */
            JSONObject contenido = JSONUtils.getObjectFromUrl("http://ip-api.com/json/213.0.87.123");

            /* P2) Recorrer los campos del JSONObject y mostrar la clave y valor de
            cada par. */
            if(contenido != null){
            
                Iterator<String> keys = contenido.keys();
                
                while(keys.hasNext()){
                    String key = keys.next();
                    Object value = contenido.get(key);
                    
                    System.out.println("Clave: " + key);
                    System.out.println("Valor: " + value);
                    System.out.println("");
                }
                
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getStackTrace());
        }

    }

}
