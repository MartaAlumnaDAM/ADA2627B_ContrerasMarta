package menu;

import bdseries.Series;
import bdseries.SeriesJpaController;
import java.util.List;

public class JPAVista {

    public static void verSeries(SeriesJpaController daoSeries){
        
        List<Series> lista = daoSeries.findSeriesEntities();
        
        System.out.println("===========================");
        System.out.println("Muestra series");
        System.out.println("===========================");
        
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
    

}
