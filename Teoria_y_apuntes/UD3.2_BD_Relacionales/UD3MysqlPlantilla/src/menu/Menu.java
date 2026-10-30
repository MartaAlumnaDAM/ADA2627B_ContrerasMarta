
package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import packUtils.Colores;
import packUtils.UtilString;

public class Menu {

    public static void Mostrar() {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario    
        
        while (!salir) {
            UtilString.Linea();
            System.out.print(Colores.FONDO_BLANCO);
            System.out.println(Colores.LETRA_AZUL + "1. Mostrar todos los libros");
            System.out.println(Colores.LETRA_AZUL + "2. Añadir datos de libros");
            System.out.println(Colores.LETRA_AZUL + "3. Buscar libro por autor");
            System.out.println(Colores.LETRA_AZUL + UtilString.StrRepetir('-',20));
            System.out.println(Colores.LETRA_AZUL + "0. Salir");
            System.out.println(Colores.LETRA_AZUL + UtilString.StrRepetir('-',20));

            try {
                
                System.out.print(Colores.LETRA_NEGRO + "Escribe una de las opciones: ");
                opcion = sn.nextInt();

                UtilString.Linea();
                switch (opcion) {
                    case 1:
                        Opciones.mostrarLibros();
                        break;  
                    case 2:
                        Opciones.addLibro();
                        break;  
                    case 3:
                        Opciones.buscaLibro();
                        break;  
                        
                    // **************************
                    // SALIR
                    // **************************
                    case 0:
                        salir = true;
                        System.out.println("Terminado");
                        UtilString.Linea();
                        break;                        
                    default:
                        System.out.println(Colores.LETRA_ROJO + Colores.FONDO_AMARILLO + "Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                UtilString.Linea();
                System.out.println(Colores.LETRA_ROJO + Colores.FONDO_AMARILLO + "Debe insertar un número");
                sn.next();
            }
        }               
              
    }
    
    
    
    
}
