package app;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fich14BuscarSecuencial {

    public static void main(String args[]) {
        boolean encontrado = false;
        String nombre;
        String apellidos;
        int edad;

        String busqueda = "Pedro";

        try (DataInputStream archivo
                = new DataInputStream(new FileInputStream("./datos/secuencial.dat"))) {

            // Leer archivo
            while ((!encontrado) && (archivo.available() > 0)) {
                // Leer el nombre
                nombre = archivo.readUTF();

                // Si el nombre es el que buscamos
                if (busqueda.equals(nombre)) {
                    encontrado = true;
                    System.out.println("Registro Encontrado!!");

                    // Leer los otros campos
                    apellidos = archivo.readUTF();
                    edad = archivo.readInt();

                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellidos: " + apellidos);
                    System.out.println("Edad: " + edad);
                } else {
                    // Leer los otros campos
                    apellidos = archivo.readUTF();
                    edad = archivo.readInt();
                }
            }

            if (!encontrado) {
                System.out.println("Registro NO Encontrado!!");
            }

        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            /* Error al escribir */
            System.out.println(ioe.getMessage());
        }

    }
}
