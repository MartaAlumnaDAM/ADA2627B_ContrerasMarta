package app;

import java.io.*;

public class Fich09FicheroBinarioBloques {

    public static void main(String[] args) {
        // Copiar todo un fichero, con bloques de 512 Kb
        File fichIn = new File("./datos/fichero.in");
        File fichOut = new File("./datos/fichero.out");

        System.out.println("Copiando fichero binario...");
        final int BUFFER_SIZE = 512 * 1024;
        try (
                InputStream ficheroEntrada = new FileInputStream(fichIn);
                OutputStream ficheroSalida = new FileOutputStream(fichOut);
                    ) {
            
            byte[] buf = new byte[BUFFER_SIZE];
            int cantidadLeida;
            while ((cantidadLeida = ficheroEntrada.read(buf, 0, BUFFER_SIZE)) > 0) {
                ficheroSalida.write(buf, 0, cantidadLeida);
            }

        } catch (Exception errorDeFichero) {
            System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
        }
        System.out.println("Terminado!");
    }
}
