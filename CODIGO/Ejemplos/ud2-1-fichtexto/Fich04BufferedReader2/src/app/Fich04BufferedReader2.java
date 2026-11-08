package app;

public class Fich04BufferedReader2 {


    public static void main(String[] args) {

        System.out.println("LEER FICHERO");
        Fichero.MostrarFichero("./datos/ejemplo3.txt");
        System.out.println("");
        
        System.out.println("LEER FICHERO");
        Fichero.MostrarFichero("./datos/ejemplo-no-existe.txt");
        System.out.println("");
    }
    
}
