package app;

import java.io.File;

public class Fich02Fich2 {

    public static void main(String[] args) {

        try {
            File fichero = new File("./datos/miFichero.txt");

            if (fichero.exists()) {
              fichero.delete();
            }            
            
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
