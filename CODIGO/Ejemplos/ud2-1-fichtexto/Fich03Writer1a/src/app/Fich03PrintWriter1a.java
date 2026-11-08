package app;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Fich03PrintWriter1a {

    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter("./datos/ejemplo1a.txt", StandardCharsets.UTF_8);
            printWriter.println("Hola!");
            printWriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
