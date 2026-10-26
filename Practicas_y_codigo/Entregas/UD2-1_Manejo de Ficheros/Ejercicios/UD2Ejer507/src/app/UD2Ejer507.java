package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UD2Ejer507 {

    public static void main(String[] args) {

        File archivo;
        String mes = "";

        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("Indica la cantidad de dias del mes: ");
            int diasMes = Integer.parseInt(entrada.nextLine());
            if (diasMes < 28 || diasMes > 31) {
                System.out.println("Un mes debe tener entre 28 y 31 dias.");
            } else {
                System.out.println("Indica el primer dia del mes (1 para lunes, 7 para domingo.");
                int primerDia = Integer.parseInt(entrada.nextLine());

                if (primerDia < 1 || primerDia > 7) {
                    System.out.println("El primer dia debe estar entre 1 y 7.");
                } else {
                    System.out.println("Indica el nombre del mes: ");
                    mes = entrada.nextLine();

                }

                archivo = new File("./datos/calendario" + mes.toUpperCase() + ".txt");
                
                if(archivo.exists()){archivo.delete();}

                try (PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream(archivo, true),
                                        StandardCharsets.UTF_8)))) {

                    pw.println("-".repeat(10));
                    pw.println(mes);
                    pw.println("-".repeat(10));

                    pw.println("lun   mar   mie   jue   vie   sab   dom");
                    pw.println("-".repeat(40));

                    int columnaActual = 1;

                    for (int i = 1; i < primerDia; i++) {
                        pw.print("      ");
                        columnaActual++;
                    }

                    for (int i = 1; i <= diasMes; i++) {
                        pw.printf("%-6d", i);

                        columnaActual++;
                        
                        if (columnaActual > 7) {
                            pw.println();
                            columnaActual = 1;
                        }

                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("El valor introducido es incorrecto.");
        }
    }

}
