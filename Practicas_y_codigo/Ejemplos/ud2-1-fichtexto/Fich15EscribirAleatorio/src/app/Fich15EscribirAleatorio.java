package app;

import java.io.*;

public class Fich15EscribirAleatorio {

    public static void main(String[] args)  {

        try ( RandomAccessFile miRandomFile 
                = new RandomAccessFile("./datos/aleatorio.bin", "rw") ) {

            // Nos vamos al final del fichero
            miRandomFile.seek(miRandomFile.length());

            // Incorporamos la cadena al fichero
            String texto = "Cadena a escribir\n";
            miRandomFile.writeBytes(texto);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
