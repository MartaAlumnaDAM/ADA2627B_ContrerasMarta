package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Fich02Dir3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear carpetas y ficheros temporales
        File dirtmp = new File("./datos/tmp/files");
        File fichtmp;

        try {
            dirtmp.mkdirs();
            fichtmp = new File("./datos/tmp/files/fichero1.txt");
            fichtmp.createNewFile();
            fichtmp = new File("./datos/tmp/files/fichero2.txt");
            fichtmp.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar carpetas y ficheros temporales
        File dir = new File("./datos/tmp");
        System.out.println("------------------------------------");
        listDir(dir);

        // Eliminar carpetas y ficheros temporales
        System.out.println("------------------------------------");
        System.out.print("\n¿Deseas eliminar la carepta ./datos/tmp? (S/N): ");
        String respuesta = scanner.nextLine().toUpperCase();
        if (respuesta.equals("S")) {
            delDir(dir);
            listDir(dir);
        }

    }

    private static void listDir(File dir) {
        File[] ficheros = dir.listFiles();
        for (File file : ficheros) {
            System.out.println(file.getAbsolutePath() + "\\" + file.getName());
            if (file.isDirectory()) {
                listDir(file);
            }
        }
    }

    private static void delDir(File dir) {
        File[] ficheros = dir.listFiles();
        for (File file : ficheros) {
            if (file.isDirectory()) {
                delDir(file);
            }
            file.delete();
        }
    }

}
