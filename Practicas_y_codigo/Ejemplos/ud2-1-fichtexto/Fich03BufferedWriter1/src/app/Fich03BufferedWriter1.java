package app;

import java.io.*;

public class Fich03BufferedWriter1 {

    public static void main(String[] args) {
        BufferedWriter ficheroSalida = null;
        try {
            ficheroSalida = new BufferedWriter(new FileWriter(new File("./datos/ejemplo4a.txt")));
            ficheroSalida.write("Línea 1");
            ficheroSalida.newLine();
            ficheroSalida.write("Línea 2");
            ficheroSalida.newLine();
        } catch (IOException e) {
            System.out.println("Ha habido problemas: " + e.getMessage());
        } finally {
            try {
                if (ficheroSalida != null) {
                    ficheroSalida.close();
                }
            } catch (IOException e) {
                System.out.println("Ha habido problemas: " + e.getMessage());
            }
        }
    }
}
