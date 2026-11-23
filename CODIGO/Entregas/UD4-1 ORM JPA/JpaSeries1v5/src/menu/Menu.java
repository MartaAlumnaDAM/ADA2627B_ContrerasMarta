
package menu;

import bdseries.SeriesJpaController;
import jakarta.persistence.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import packUtils.Colores;
import packUtils.JPAUtil;
import packUtils.UtilString;
import static packUtils.UtilString.*;

public class Menu {

    public static void mostrar() {
        
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        
        //Genera dao
        SeriesJpaController daoSeries = new SeriesJpaController(emf);
        
        /*---- Menú ---- */
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario    
        
        while (!salir) {
            linea();
            System.out.print(Colores.FONDO_BLANCO);
            System.out.println(Colores.LETRA_AZUL + UtilString.strRepetir('-',20));
            System.out.println(Colores.LETRA_AZUL + "1. Mostrar series");
            System.out.println(Colores.LETRA_AZUL + "2. Añadir serie");
            System.out.println(Colores.LETRA_AZUL + "3. Buscar serie por titulo");
            System.out.println(Colores.LETRA_AZUL + "4. Buscar serie por duración");
            System.out.println(Colores.LETRA_AZUL + "5. Mostrar series por canal");
            System.out.println(Colores.LETRA_AZUL + "0. Salir");
            System.out.println(Colores.LETRA_AZUL + UtilString.strRepetir('-',20));

            try {
                
                System.out.print(Colores.LETRA_NEGRO + "Escribe una de las opciones: ");
                opcion = sn.nextInt();

                linea();
                switch (opcion) {
                    case 1:
                        JPAVista.verSeries(daoSeries);
                        break; 
                    case 2:
                        JPAVista.agregaSeries(daoSeries);
                        break;
                    case 3:
                        JPAVista.seriePorTitulo(daoSeries);
                        break;
                    case 4:
                        JPAVista.seriePorDuracion(daoSeries);
                        break;
                    case 5:
                        JPAVista.seriesPorCanal(daoSeries);
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
