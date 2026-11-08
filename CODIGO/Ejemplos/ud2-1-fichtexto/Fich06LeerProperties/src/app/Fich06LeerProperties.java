package app;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fich06LeerProperties {

    public static void main(String args[]) throws FileNotFoundException, IOException {

        // Preparar Variables
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("./datos/usuario.properties");

        // Leer datos
        properties.load(fis);

        // Cerrar fichero
        fis.close();

        // Mostrar todas las propiedades
        System.out.println("Properties......: " + properties.toString());

        // Mostrar todas las claves
        System.out.println("Claves..........: " + properties.keySet());

        // Mostrar valor de una clave
        System.out.println("Valor de usuario: " + properties.getProperty("usuario"));

        // Recorrer todas las propiedades
        System.out.println("------------------");
        properties.forEach((k, v) -> {
            System.out.println("Clave: " + k);
            System.out.println("Valor: " + v);
            System.out.println("------------------");
        });

    }
}
