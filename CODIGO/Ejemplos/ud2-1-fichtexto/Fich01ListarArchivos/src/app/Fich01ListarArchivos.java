package app;

import java.io.*;

public class Fich01ListarArchivos {

    public static void main(String[] args) {

        String carpeta = "C:/Windows";

        // Obtenemos la ruta del campo de texto y la pasamos al constructor
        File ruta = new File(carpeta);

        // Comprobamos si existe esa carpeta
        if (ruta.exists()) {

            // Obtenemos la lista de archivos
            String[] listaArchivos = ruta.list();

            // Mostramos la lista
            for (int i = 0; i < listaArchivos.length; i++) {
                System.out.println(listaArchivos[i]);
            }
        }

    }
}
