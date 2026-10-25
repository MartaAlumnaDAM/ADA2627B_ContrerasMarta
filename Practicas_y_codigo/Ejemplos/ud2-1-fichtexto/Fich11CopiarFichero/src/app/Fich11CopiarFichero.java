package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fich11CopiarFichero {

    public static void main(String args[]) {
        String strfuente = "./datos/datosbinarios.dat";
        String strdestino= "./datos/datosbinarioscopia.dat";
        
        if (args.length>=2) {
            strfuente = args[0];
            strdestino = args[1];
        }
        
        
        try (
                // El fichero fuente es el primer parámetro
                FileInputStream fuente = new FileInputStream(strfuente);
                // El fichero destino es el segundo parámetro.
                FileOutputStream destino = new FileOutputStream(strdestino, false);
                  ) {

            // Leer del fuente hasta llegar la fin de archivo
            int i = fuente.read();
            while (i != -1) { // mientras not EOF
                destino.write(i);
                i = fuente.read();
            }

        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            /* Error al escribir */
            System.out.println(ioe.getMessage());
        } catch (Exception e) {
            /* Error general */
            System.out.println("Error en el tratamiento de los ficheros");
        }
    }
}
