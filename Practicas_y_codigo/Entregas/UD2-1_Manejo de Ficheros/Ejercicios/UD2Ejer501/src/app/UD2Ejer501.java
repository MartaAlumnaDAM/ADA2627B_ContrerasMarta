/*
Crea un programa que pida dos frases al usuario y las guarde en un
fichero llamado "frases1.txt".
 */
package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UD2Ejer501 {

    public static void main(String[] args) {

        int cantidad = 0;

        do {

            System.out.println("Introduce una frase: ");
            Scanner entrada = new Scanner(System.in);
            String frase = entrada.nextLine();

            try (PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("./datos/frases1.txt", true),
                                    StandardCharsets.UTF_8)));) {

                pw.println(frase);

                cantidad++;

            } catch (IOException e) {
                System.err.println("Error al escribir la frase");
            }

        } while (cantidad < 2);

    }

}
