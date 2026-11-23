package menu;

import bdagenda.TareasJpaController;
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

        //Generar daos
        TareasJpaController daoTareas = new TareasJpaController(emf);

        /*---- Menú ---- */
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario    

        while (!salir) {
            linea();
            System.out.print(Colores.FONDO_BLANCO);
            System.out.println(Colores.LETRA_AZUL + UtilString.strRepetir('-', 20));
            System.out.println(Colores.LETRA_AZUL + "1. Ver tareas");
            System.out.println(Colores.LETRA_AZUL + "2. Agregar tarea");
            System.out.println(Colores.LETRA_AZUL + "3. Ver Tareas pendientes próximos 3 días");
            System.out.println(Colores.LETRA_AZUL + "0. Salir");
            System.out.println(Colores.LETRA_AZUL + UtilString.strRepetir('-', 20));

            try {

                System.out.print(Colores.LETRA_NEGRO + "Escribe una de las opciones: ");
                opcion = sn.nextInt();

                linea();
                switch (opcion) {
                    case 1:
                        JPAVista.verTareas(daoTareas);
                        break;
                    case 2:
                        JPAVista.anadirTarea(daoTareas);
                        break;
                    case 3:
                        JPAVista.verTareasProximas(daoTareas);
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
