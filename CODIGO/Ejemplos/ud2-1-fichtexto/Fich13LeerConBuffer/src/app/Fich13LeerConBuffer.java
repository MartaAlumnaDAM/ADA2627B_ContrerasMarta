package app;

import java.io.*;

public class Fich13LeerConBuffer {

    public static void main(String[] args) {
        String texto = "";

        try (   
                FileReader fichero = new FileReader("./datos/archivotexto.txt");
                BufferedReader buffer = new BufferedReader(fichero);
                   ) {

            // Leemos el texto usando el metodo readLine()
            while ((texto = buffer.readLine()) != null) {
                System.out.println(texto);
            }

        } catch (IOException e) {
            // Escribir el error en la consola
            System.err.println("Error: " + e);
        }
    }
}
