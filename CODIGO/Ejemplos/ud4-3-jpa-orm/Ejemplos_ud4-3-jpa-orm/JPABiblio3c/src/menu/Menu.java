
package menu;

import bibliotecah2.AutoresJpaController;
import bibliotecah2.JPAUtil;
import bibliotecah2.JPAVista;
import bibliotecah2.LibrosJpaController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import jakarta.persistence.EntityManagerFactory;
import packUtils.Colores;
import packUtils.UtilString;
import static packUtils.UtilString.*;

public class Menu {

    public static void mostrar() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        LibrosJpaController daoLibros = new LibrosJpaController(emf);      
        AutoresJpaController daoAutores = new AutoresJpaController(emf); 
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario    
        
        while (!salir) {
            linea();
            System.out.print(Colores.FONDO_BLANCO);
            System.out.println(Colores.LETRA_AZUL + "1. Mostrar libros");
            System.out.println(Colores.LETRA_AZUL + "2. Mostrar autores");
            System.out.println(Colores.LETRA_AZUL + "3. Añadir libro");
            System.out.println(Colores.LETRA_AZUL + UtilString.strRepetir('-',20));
            System.out.println(Colores.LETRA_AZUL + "0. Salir");
            System.out.println(Colores.LETRA_AZUL + UtilString.strRepetir('-',20));

            try {
                
                System.out.print(Colores.LETRA_NEGRO + "Escribe una de las opciones: ");
                opcion = sn.nextInt();

                linea();
                switch (opcion) {
                    case 1:
                        JPAVista.verLibrosFind(daoLibros);
                        break;  
                    case 2:
                        JPAVista.verAutores(daoAutores);
                        break;  
                    case 3:
                        JPAVista.addLibro(daoAutores, daoLibros);
                        break;  
                                         
                    // **************************
                    // SALIR
                    // **************************
                    case 0:
                        salir = true;
                        System.out.println("Terminado");
                        linea();
                        break;                        
                    default:
                        System.out.println(Colores.LETRA_ROJO + Colores.FONDO_AMARILLO + "Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                linea();
                System.out.println(Colores.LETRA_ROJO + Colores.FONDO_AMARILLO + "Debe insertar un número");
                sn.next();
            }
        }               
              
        emf.close();

    }
    
    
    
    
}
