package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Fich05StringWriter {

    public static void main(String args[]) {
        try (
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw)) {

            // Escritura en el fichero con PrintWriter
            pw.println("Este es un fichero de texto");
            pw.print("que contiene varias líneas\n");
            pw.print("y se crea con BufferedWriter.\n");
            pw.println();
            
            // Escritura en el fichero con StringWriter
            sw.write("Con write se puede escribir directamente en el StringWriter\n");
            sw.write("Incluso varias líneas.\n");
            
            System.out.println(sw.toString());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
