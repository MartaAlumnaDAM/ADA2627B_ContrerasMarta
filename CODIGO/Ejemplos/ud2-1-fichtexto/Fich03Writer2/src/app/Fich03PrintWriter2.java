package app;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Fich03PrintWriter2 {

    public static void main(String[] args) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("./datos/ejemplo2.txt", StandardCharsets.UTF_8);
            printWriter.println("Hola!");
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
