package app;

import java.io.*;

public class Fich08FileInputStream1 {

    public static void main(String[] args) {

        // Cantidad de "a" en un fichero de cualquier tipo, 
        // comprobando errores sólo con try-catch 
        System.out.println("Contando \"a\"...");
        int contador = 0;
        try (FileInputStream ficheroEntrada = new FileInputStream(new File("./datos/fichero.bin"))) {

            int dato = ficheroEntrada.read();
            while (dato != -1) {
                if (dato == 97) { // Codigo ASCII de "a" 
                    contador++;
                }
                dato = ficheroEntrada.read();
            }

            ficheroEntrada.close();
        } catch (Exception errorDeFichero) {
            System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
        }
        System.out.println("Cantidad de \"a\": " + contador);
    }
}
