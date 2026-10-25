package app;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fich10EscribirSecuencial {

    public static void main(String args[]) {

        String strFichero = "./datos/secuencial.dat";
        int edad = 32;

        // Abir, capturar y grabar datos
        try (DataOutputStream archivo = new DataOutputStream(new FileOutputStream(strFichero, false))) {

            // Escribir nombre, apellidos y edad
            archivo.writeUTF("Juan");
            archivo.writeUTF("Sánchez");
            archivo.writeInt(edad);

            archivo.writeUTF("Pedro");
            archivo.writeUTF("Gómez");
            archivo.writeInt(35);

            archivo.writeUTF("Ana");
            archivo.writeUTF("Pérez");
            archivo.writeInt(27);

            System.out.println(strFichero + " creado.");

        } catch (IOException ioe) {
            /* Error al escribir */
            System.out.println(ioe.getMessage());
        } catch (Exception e) {
            /* Error de otro tipo*/
            System.out.println(e.getMessage());
        }

    }

}
