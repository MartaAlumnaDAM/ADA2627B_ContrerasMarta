package app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Fich05LeerTextoUTF8Completo {

    public static void main(String args[]) {
        try {
            String contenido = new String(
                      Files.readAllBytes(Paths.get("./datos/archivotexto.txt")),
                      StandardCharsets.UTF_8);
            System.out.println(contenido);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
