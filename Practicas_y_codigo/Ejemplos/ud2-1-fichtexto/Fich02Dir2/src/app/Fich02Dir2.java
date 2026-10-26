package app;

import java.io.File;

public class Fich02Dir2 {

    public static void main(String[] args) {

        try {
            File dir = new File("./datos");
            File[] ficheros = dir.listFiles();

            for (File file : ficheros) {
                System.out.println(file.getName());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
