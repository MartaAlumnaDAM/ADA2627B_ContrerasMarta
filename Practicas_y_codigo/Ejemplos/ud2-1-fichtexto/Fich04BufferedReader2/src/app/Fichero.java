package app;

import java.io.*;

public class Fichero {
    
   public static void MostrarFichero(String sFich) { 

        try {
            if (Fichero.existeFichero(sFich)) {
                System.out.println("SI EXISTE");
            } else {
                System.out.println("NO EXISTE");
            }
            Fichero.Leer(sFich);
        } catch( FileNotFoundException e ) {
            System.out.println( "ERROR - FICHERO NO EXISTE: " + e.getMessage());
        } catch( IOException e ) {
            System.out.println( "ERROR - IO Entrada/Salida: " + e.getMessage());
        } catch( Exception e ) {
            System.out.println( "ERROR: " + e.getMessage() );
        }          
    
   } 
    
   public static void Leer(String sFich) throws Exception {
        String cadena;
       
        FileReader f = new FileReader(sFich);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
        f.close();
    }
   
    public static boolean existeFichero(String sFich) throws Exception {
        File f = new File(sFich); // Define el objeto con nuestro Archivo
        return f.exists();
    }
    
    
   
} 

