/*
 Crea un programa que pida frases al usuario (una cantidad indeterminada,
hasta que introduzca una línea vacía) y las almacene en un fichero
llamado "frases2.txt". Cada vez que se lance el programa, se destruirá
el fichero "frases2.txt" y se creará uno nuevo que lo reemplace.
 */
package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UD2Ejer502 {

    public static void main(String[] args) {

        System.out.println("Introduce una frase (linea vacia para terminar): ");
        Scanner entrada = new Scanner(System.in);
        String frase = entrada.nextLine();
        
        File fichero = new File("./datos/frases2.txt");   
            if (fichero.exists()) {
                fichero.delete();
            }

        while (!frase.isEmpty()) {

            try (PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(
                                            "./datos/frases2.txt", true),
                                    StandardCharsets.UTF_8)));) {
                
                pw.println(frase);

                System.out.println("Introduce una frase: ");
                frase = entrada.nextLine();


            } catch (IOException e) {
                System.err.println("Error al recibir la frase");
            }

        }

    }

}
