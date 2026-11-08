package app;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Fich07LeerBinario {

    public static void main(String args[]) {
        String texto;
        int entero;

        String fileName = "./datos/datosbinarios.dat";
        try (
                FileInputStream foStream = new FileInputStream(fileName);
                DataInputStream doStream = new DataInputStream(foStream);
                    ) {

            texto = doStream.readUTF();
            entero = doStream.readInt();

            System.out.println("String: " + texto);
            System.out.println("Int: " + entero);

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
