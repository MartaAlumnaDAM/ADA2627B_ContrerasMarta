package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fich04BufferedReader1 {

    public static void main(String[] args) {

        // Primero vemos si el fichero existe 
        if (!(new File("./datos/ejemplo3.txt")).exists()) {
            System.out.println("No he encontrado ejemplo3.txt");
            return;
        }

        // En caso de que exista, intentamos leer
        System.out.println("Leyendo fichero...");

        try (BufferedReader ficheroEntrada = new BufferedReader(
                new FileReader(new File("./datos/ejemplo3.txt")))) {

            String linea = null;

            linea = ficheroEntrada.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = ficheroEntrada.readLine();
            }

        } catch (IOException e) {
            System.out.println("Ha habido problemas: " + e.getMessage());
        }

        System.out.println("Fin de la lectura.");
    }
}
