/*
 Crea una variante del ejercicio UD2Ejer02, en la que el fichero se
llamará "frases3.txt" y no se destruirá en cada nueva ejecución, sino
que se añadirán las nuevas frases al final de las existentes.

 */
package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UD2Ejer503 {

    public static void main(String[] args) {
        System.out.println("Escriba una frase (linea vacia para terminar): ");
        Scanner entrada = new Scanner(System.in);
        String frase = entrada.nextLine();
        File archivo = new File("./datos/frases3.txt");

        while (!frase.isEmpty()) {

            try (PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(archivo, true),
                                    StandardCharsets.UTF_8)))) {

                pw.println(frase);
                
                System.out.println("Escriba una frase (linea vacia para terminar): ");
                frase = entrada.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
