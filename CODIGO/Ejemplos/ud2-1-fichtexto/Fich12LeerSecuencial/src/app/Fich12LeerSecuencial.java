package app;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fich12LeerSecuencial {

    public static void main(String args[]) {
        String nombre = "";
        String apellidos = "";
        int edad = 0;

        try (DataInputStream archivo
                = new DataInputStream(new FileInputStream("./datos/secuencial.dat"))) {

            // Leer archivo
            while (archivo.available() > 0) {

                nombre = archivo.readUTF();
                apellidos = archivo.readUTF();
                edad = archivo.readInt();

                System.out.println("------------------------------");
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellidos: " + apellidos);
                System.out.println("Edad: " + edad);
            }
            System.out.println("------------------------------");

        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            /* Error al escribir */
            System.out.println(ioe.getMessage());
        }

    }
}
