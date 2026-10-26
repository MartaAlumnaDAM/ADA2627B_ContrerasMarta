package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Fich06EscribirProperties {

    public static void main(String args[]) throws FileNotFoundException, IOException {

        // Crear Fichero
        Properties props = new Properties();
        FileOutputStream fos = new FileOutputStream("./datos/usuario.properties");

        // Almacenar datos
        // props.setProperty() es equivalente a properties.put()
        props.setProperty("usuario", "juan");
        props.setProperty("email", "juan@dominio.com");

        // Escribir las propiedades en el fichero
        props.store(fos, "Fichero de propiedades generado desde programa Java");

        // Cerrar fichero
        fos.close();

    }
}
