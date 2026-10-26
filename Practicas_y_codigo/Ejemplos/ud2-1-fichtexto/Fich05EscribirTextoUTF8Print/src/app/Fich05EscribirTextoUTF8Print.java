package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Fich05EscribirTextoUTF8Print {

    public static void main(String args[]) {
        File archivo = new File("./datos/archivotextoUTF8.txt");

        // Apertura del fichero y creacion de PrintWriter 
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(archivo, true), StandardCharsets.UTF_8)) )) {

            // Escritura en el fichero con PrintWriter
            pw.println("Este es un fichero de texto");
            pw.print("que contiene varias líneas\n");
            pw.print("y se crea con BufferedWriter.\n");
            pw.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
