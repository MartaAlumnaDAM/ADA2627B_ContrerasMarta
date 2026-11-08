package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UD2Ejer504 {

    public static void main(String[] args) {
        System.out.println("Escriba una frase (linea vacia para terminar): ");
        Scanner entrada = new Scanner(System.in);
        String frase = entrada.nextLine();
        File archivo = new File("./datos/frases4.txt");

        while (!frase.isEmpty()) {

            try (PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(archivo, true),
                                    StandardCharsets.UTF_8)))) {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                pw.println(dtf.format(now).toString());
                pw.println(frase);

                System.out.println("Escriba una frase (linea vacia para terminar): ");
                frase = entrada.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
