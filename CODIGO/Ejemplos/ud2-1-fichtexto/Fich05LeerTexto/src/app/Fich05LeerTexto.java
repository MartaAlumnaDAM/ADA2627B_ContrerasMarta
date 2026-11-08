package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Fich05LeerTexto {

    public static void main(String args[]) {
        File archivo = new File("./datos/archivotexto.txt");
        
        // Apertura del fichero y creacion de BufferedReader
        try (   FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);) {
            
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
