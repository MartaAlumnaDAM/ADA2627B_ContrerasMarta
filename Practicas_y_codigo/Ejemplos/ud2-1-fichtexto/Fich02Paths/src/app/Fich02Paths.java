
package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Fich02Paths {

    public static void main(String[] args) {
        try {
            String archivo="./datos/ejemplo.txt";
            
            File file = new File(archivo);
            Path path = Paths.get(archivo);
            
            Path pathFromFile = file.toPath();
            System.out.println(pathFromFile);
            File fileFromPath = path.toFile();
            System.out.println(fileFromPath.toString());
            
            System.out.println("Absolute  Path (File): "+file.getAbsolutePath());
            System.out.println("Canonical Path (File): "+file.getCanonicalPath());
            System.out.println("Absolute  Path (Path): "+path.toAbsolutePath());
            System.out.println("Canonical Path (Path): "+path.toAbsolutePath().normalize());
            
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
