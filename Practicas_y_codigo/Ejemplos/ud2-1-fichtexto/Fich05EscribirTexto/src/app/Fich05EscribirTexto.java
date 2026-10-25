package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Fich05EscribirTexto {

    public static void main(String args[]) {
        File archivo = new File("./datos/archivotexto.txt");

        // Apertura del fichero y creacion de BufferedWriter
        try ( FileWriter fw = new FileWriter(archivo, false);
              BufferedWriter bw = new BufferedWriter(fw); ) {
            
            // Escritura en el fichero
            bw.write("Este es un fichero de texto");
            bw.newLine();
            bw.write("que contiene varias líneas\n");
            bw.write("y se crea con BufferedWriter.\n");

            // Forzamos la escritura en disco
            bw.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
