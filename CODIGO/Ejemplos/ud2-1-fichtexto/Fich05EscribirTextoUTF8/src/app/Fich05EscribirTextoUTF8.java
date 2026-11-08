package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;

public class Fich05EscribirTextoUTF8 {

    public static void main(String args[]) {
        File archivo = new File("./datos/archivotextoUTF8.txt");

        // Apertura del fichero y creacion de BufferedWriter 
        try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(archivo, true), StandardCharsets.UTF_8)) ) {

            // Escritura en el fichero
            bw.write("Este es un fichero de texto");
            bw.newLine();
            bw.write("que contiene varias líneas\n");
            bw.write("y se crea con BufferedWriter.\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
