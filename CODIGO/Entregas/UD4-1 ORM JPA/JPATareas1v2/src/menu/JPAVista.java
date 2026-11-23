package menu;

import bdagenda.Tareas;
import bdagenda.TareasJpaController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class JPAVista {

    public static void verTareas(TareasJpaController daoTareas){
        
        System.out.println("==".repeat(40));
        System.out.println("== Muestra tareas ==");
        System.out.println("==".repeat(40));
        
        List<Tareas> lista = daoTareas.findTareasEntities();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        String lineaSeparadora = "+" + "-".repeat(4)
            + "+" + "-".repeat(12)
            + "+" + "-".repeat(42)
            + "+" + "-".repeat(12) + "+";
        
        System.out.println(lineaSeparadora);
        System.out.printf("| %-2s | %-10s | %-40s | %-10s |%n","ID","Fecha","Descripcion","Completada");
        System.out.println(lineaSeparadora);
        
        
        for (Tareas tarea : lista) {
            String fechaFormateada = "";
            String terminada = tarea.getCompletada() ? "SI" : "NO";
            Date fecha = tarea.getFecha();
            
            if(fecha != null){
                fechaFormateada = formatoFecha.format(fecha);
            }
            
            System.out.printf("| %-2s | %-10s | %-40s | %-10s |%n",tarea.getCodigo(),fechaFormateada,tarea.getDescripcion(),terminada);
        }
        
    } 
    
    public static void anadirTarea(TareasJpaController daoTareas) {

        System.out.println("==".repeat(40));
        System.out.println("== Añadir una Tarea ==");
        System.out.println("==".repeat(40));

        String textoFecha, descripcion;
        boolean completada;
        // Java - Leer datos
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduzca la fecha (AAAA-MM-DD): ");
        textoFecha = teclado.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(textoFecha);
        
        System.out.print("Introduzca la descripción: ");
        descripcion = teclado.nextLine();
        
        System.out.println("Introduzca si está completada (SI/NO): ");
        completada = (teclado.nextLine().trim()).equalsIgnoreCase("SI") ;
        
        // Java - Cargar datos en un objeto tarea
        Tareas tarea = new Tareas();
        tarea.setCodigo(0);// Para que obtenga el siguiente usando AUTO_INCREMENT
        tarea.setDescripcion(descripcion);
        tarea.setCompletada(completada);
        tarea.setFecha(fecha);
                
        // JPA - Guardar datos del objeto directamente en la BD
        daoTareas.create(tarea);

    }
     
}
