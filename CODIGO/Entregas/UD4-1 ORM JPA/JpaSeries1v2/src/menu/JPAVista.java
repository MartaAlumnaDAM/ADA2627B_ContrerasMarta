package menu;

import bdseries.Series;
import bdseries.SeriesJpaController;
import java.util.List;
import java.util.Scanner;

public class JPAVista {

    public static void verSeries(SeriesJpaController daoSeries){
        
        System.out.println("===========================");
        System.out.println("Muestra series");
        System.out.println("===========================");
        
        List<Series> lista = daoSeries.findSeriesEntities();
        
        String lineaSeparadora = "+" + "-".repeat(4)
            + "+" + "-".repeat(22)
            + "+" + "-".repeat(12)
            + "+" + "-".repeat(10) + "+";
        
        System.out.println(lineaSeparadora);
        System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n","ID","Titulo","TV","Duracion");
        System.out.println(lineaSeparadora);
        
        
        for (Series serie : lista) {
            System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n",serie.getCodigo(),serie.getTitulo(),serie.getTv(),serie.getDuracion());
        }
        
        System.out.println(lineaSeparadora);
    }
    

    public static void agregaSeries(SeriesJpaController daoSeries){
        
        System.out.println("===========================");
        System.out.println("Agregar serie");
        System.out.println("===========================");
        
        System.out.print("Introduzca el título: ");
        Scanner teclado = new Scanner(System.in);
        String titulo = teclado.nextLine();
        
        System.out.println("Introduzca la cadena de TV: ");
        String TV = teclado.nextLine();
        
        System.out.println("Introduzca la duración: ");
        int duracion = Integer.parseInt(teclado.nextLine());
        
        Series s = new Series();
        s.setCodigo(0);
        s.setTitulo(titulo);
        s.setTv(TV);
        s.setDuracion(duracion);
        daoSeries.create(s);
        
    }
}
