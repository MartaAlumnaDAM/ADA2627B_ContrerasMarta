package app;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Fich03PrintWriter3 {

    public static void main(String[] args) {
        PrintWriter printWriter = null;
        try {
            // El parámetro true junto con el Buffer le permite añadir contenido al fichero
            printWriter = new PrintWriter(
                            new BufferedWriter(
                                new OutputStreamWriter(
                                    new FileOutputStream("./datos/ejemplo3.txt", true),
                                    StandardCharsets.UTF_8))); 
            printWriter.println("Hola otra vez!");
            printWriter.println("y...");
            printWriter.println("hasta luego!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
