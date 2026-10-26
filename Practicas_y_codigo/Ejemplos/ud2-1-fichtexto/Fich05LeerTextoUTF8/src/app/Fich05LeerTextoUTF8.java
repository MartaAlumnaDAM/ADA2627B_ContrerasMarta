package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Fich05LeerTextoUTF8 {

    public static void main(String args[]) {
        File archivo = new File("./datos/archivotexto.txt");
        
        // Apertura del fichero y creacion de BufferedReader
        try (BufferedReader br 
                = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(archivo), StandardCharsets.UTF_8)) ) {
            
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}
