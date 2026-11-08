package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UD2Ejer506 {

    public static String obtenerNombreDia(int numeroDia) {
        String textoDia = switch (numeroDia) {

            case 1 ->
                "Lunes";
            case 2 ->
                "Martes";
            case 3 ->
                "Miércoles";
            case 4 ->
                "Jueves";
            case 5 ->
                "Viernes";
            case 6 ->
                "Sábado";
            case 7 ->
                "Domingo";
            default ->
                "no existe";
        };

        return textoDia;
    }

    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            try {
                System.out.println("Indica la cantidad de dias del mes: ");
                int dias = Integer.parseInt(entrada.nextLine());

                System.out.println("Indica el número del primer dia (1 para lunes, 7 para domingo): ");
                int numeroDia = Integer.parseInt(entrada.nextLine());
                if (numeroDia < 1 || numeroDia > 7) {
                    System.out.println("Error: El primer día debe estar entre 1 y 7.");
                    return;
                } 

                System.out.println("Indica el nombre del mes: ");
                String mes = entrada.nextLine();

                File archivo = new File("./datos/agenda" + mes + ".txt");

                if (archivo.exists()) {
                    archivo.delete();
                };

                try (PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream(archivo),
                                        StandardCharsets.UTF_8)))) {

                    pw.println(mes);
                    pw.println("-".repeat(50));

                    for (int i = 1; i <= dias; i++) {
                        String textoDia = obtenerNombreDia(numeroDia);
                        pw.println(textoDia + " " + i + ":");
                        pw.println("-".repeat(50));
                        numeroDia++;

                        if (numeroDia > 7) {
                            numeroDia = 1;
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Valor introducido, no válido.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor introducido, no válido.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
