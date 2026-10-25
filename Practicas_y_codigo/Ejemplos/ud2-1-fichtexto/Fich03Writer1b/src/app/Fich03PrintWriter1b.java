package app;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Fich03PrintWriter1b {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        PrintWriter printWriter = new PrintWriter("./datos/ejemplo1b.txt", StandardCharsets.UTF_8);
        printWriter.println("Hola!");
        printWriter.close();
    }
}
