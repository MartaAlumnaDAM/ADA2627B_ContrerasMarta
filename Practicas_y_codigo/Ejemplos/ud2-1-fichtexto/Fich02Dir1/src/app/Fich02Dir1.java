package app;

import java.io.File;

public class Fich02Dir1 {

    public static void main(String[] args) {

        try {
            boolean exito;
            String directorio = "./datos";
            String varios = "./datos/carpeta1/carpeta2/carpeta3";

            File dir = new File(directorio);
            
            if (!dir.exists()) {
                exito = (new File(directorio)).mkdir();
                if (exito) {
                    System.out.println("Directorio: " + directorio + " creado");
                }
            }
            
            if (dir.exists()) {
                exito = (new File(varios)).mkdirs();
                if (exito) {
                    System.out.println("Directorios: " + varios + " creados");
                }
            } 
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
