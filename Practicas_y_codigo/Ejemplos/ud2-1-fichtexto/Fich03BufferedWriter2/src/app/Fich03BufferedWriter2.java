package app;

import java.io.*;

public class Fich03BufferedWriter2 {

    public static void main(String[] args) {

        try (BufferedWriter ficheroSalida = new BufferedWriter(
                new FileWriter(new File("./datos/ejemplo4b.txt")))) {

            ficheroSalida.write("Línea 1");
            ficheroSalida.newLine();
            ficheroSalida.write("Línea 2");
            ficheroSalida.newLine();

        } catch (IOException e) {
            System.out.println("Ha habido problemas: " + e.getMessage());
        }
    }
}
