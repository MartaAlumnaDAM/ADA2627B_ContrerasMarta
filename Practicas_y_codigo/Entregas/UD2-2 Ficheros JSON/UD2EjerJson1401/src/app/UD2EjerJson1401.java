/*
Dado un archivo con datos de contenedores de frutas con el formato
siguiente (archivo json adjunto en ./datos): 
Realizar aplicación que realice los siguientes procesos:
P1) Cargar Archivo a Memoria en objeto de JSONArray
P2) Recorrer los JSONObject del JSONArray y mostrar los datos por
consola de aquellos cuyo país de origen sea "FR".
Formatearemos el resultado con System.out.printf.
El resultado será:
Contenedores del país FR
------------------------
IdContenedor: 1 Producto: Sandías País: FR Ciudad: Lons-le-Saunier
IdContenedor: 2 Producto: Fresas País: FR Ciudad: Évry
IdContenedor: 3 Producto: Naranjas País: FR Ciudad: Paris 10
IdContenedor: 4 Producto: Fresas País: FR Ciudad: Paris 10
IdContenedor: 5 Producto: Mandarinas País: FR Ciudad: Seynod
IdContenedor: 6 Producto: Fresas País: FR Ciudad: Arras
 */
package app;

import org.json.JSONObject;
import utils.JSONUtils;
import org.json.JSONArray;

public class UD2EjerJson1401 {

    public static void main(String[] args) {

        try {

            /*P1) Cargar archivo a memoria en objeto de JSONArray*/
            String fichero = "./datos/contenedores-frutas-50.json";
            JSONArray contenedores = JSONUtils.getArrayFromFile(fichero);

            /*P2) Recorrer los objetos del array y mostrar solo los de Francia*/
            System.out.println("Contenedores del pais FR");
            System.out.println("---".repeat(40));

            for (Object jObj : contenedores) {

                JSONObject contenedor = (JSONObject) jObj;

                String pais = contenedor.getString("pais");

                if (pais.equalsIgnoreCase("FR")) {

                    Integer id = contenedor.getInt("idContenedor");
                    String producto = contenedor.getString("producto");
                    String ciudad = contenedor.getString("ciudad");
                    System.out.printf("IdContenedor: %-3d Producto: %-16s Pais: %-4s Ciudad: %-20s \n", id, producto, pais, ciudad);

                }

            }

            System.out.println("---".repeat(40));

        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

}
