package app;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fich07EscribirBinario {

    public static void main(String args[]) {

        String texto = "Esto es un texto para almacenarlo\n en el archivo binario.\n";

        // Nombre del fichero donde se escribirá la información
        String fileName = "./datos/datosbinarios.dat";

        try (    
              //  Se declara un objeto de tipo DataOutputStream
              FileOutputStream foStream = new FileOutputStream(fileName);
              DataOutputStream doStream = new DataOutputStream(foStream);
                   ) {

            // Escribir cadena de texto
            doStream.writeUTF(texto);

            // Escribir un entero 5
            doStream.writeInt(5);

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }

}
