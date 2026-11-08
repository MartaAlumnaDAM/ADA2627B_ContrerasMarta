package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UD2Ejer505 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        File archivo = new File("./datos/rectangulo.txt");

        System.out.println("Introduce una anchura: ");
        int anchura = Integer.parseInt(entrada.nextLine());
        System.out.println("Introduce una altura: ");
        int altura = Integer.parseInt(entrada.nextLine());

        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(archivo, true), StandardCharsets.UTF_8)))) {
            
            for(int i = 0; i < altura; i++){
                for(int j = 0; j < anchura; j++){
                    pw.print('*');
                }
                pw.println();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
