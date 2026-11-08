/*
* @author marta
 Dado un archivo con datos de sistemas operativos con el formato
siguiente (el profesor entregará el archivo completo):
[
{"Id":1, "Nombre":"Windows"},
{"Id":2, "Nombre":"Linux"},
{"Id":3, "Nombre":"Mac OS"}
]
Realizar aplicación que realice los siguientes procesos:
P1) Cargar Archivo a Memoria en objeto de JSONArray
P2) Recorrer el JSONArray de JSONObject con for(int i=0;...
P3) Recorrer el JSONArray de JSONObject con for(Object obj: ...)
P4) Recorrer el JSONArray de JSONObject con Iterator
P5) Muestra directamente el valor de "Nombre" del registro 3
 */
package app;

import java.util.Iterator;
import utils.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class UD2EjerJson1402 {

    public static void main(String[] args) {

        /* P1) Cargar Archivo a Memoria en objeto de JSONArray */
        String fichero = "./datos/sistoperativos.json";
        JSONArray sistemas = JSONUtils.getArrayFromFile(fichero);

        /*P2) Recorrer el JSONArray de JSONObject con for(int i=0;...*/
        System.out.println("Recorrer el Array de Objetos con FOR y contador");
        System.out.println("---".repeat(40));
        for (int i = 0; i < sistemas.length(); i++) {

            JSONObject sistema = (JSONObject) sistemas.getJSONObject(i);
            System.out.println("Id: " + sistema.getInt("Id"));
            System.out.println("Nombre: " + sistema.getString("Nombre"));
            System.out.println();
        }

        /* P3) Recorrer el JSONArray de JSONObject con for(Object obj: ...)*/
        System.out.println("Recorrer el Array de Objetos con FOR de elementos");
        System.out.println("---".repeat(40));
        for (Object obj : sistemas) {

            JSONObject sistema = (JSONObject) obj;
            
            String salida = "{\"Id\":" + sistema.getInt("Id") + ",\"Nombre\":\"" + sistema.getString("Nombre")+ "\"}";
            System.out.println(salida);

            Integer id = sistema.getInt("Id");
            String nombre = sistema.getString("Nombre");
            System.out.println("Id: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("");

        }

        /*P4) Recorrer el JSONArray de JSONObject con Iterator*/
        System.out.println("Recorrer el Array de Objetos con ITERATOR");
        System.out.println("---".repeat(40));

        Iterator<Object> iterador = sistemas.iterator();

        while (iterador.hasNext()) {

            Object obj = iterador.next();

            JSONObject sistema = (JSONObject) obj;
            String salida = "{\"Id\":" + sistema.getInt("Id") + ",\"Nombre\":\"" + sistema.getString("Nombre") + "\"}";
            System.out.println(salida);
            //System.out.println(sistema.toString());
            System.out.println("Id: " + sistema.getInt("Id"));
            System.out.println("Nombre: " + sistema.getString("Nombre"));
            System.out.println("");
        }

        /*P5) Muestra directamente el valor de "Nombre" del registro 3*/
        System.out.println("Acceso directo a un elemento");
        System.out.println("---".repeat(40));
        System.out.println("Del elemento con indice 2 -> obtener el Nombre");
        System.out.println(sistemas.getJSONObject(2).getString("Nombre"));

    }

}
