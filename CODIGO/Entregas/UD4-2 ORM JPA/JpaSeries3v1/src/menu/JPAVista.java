package menu;

import bdseriestv.Canalestv;
import bdseriestv.CanalestvJpaController;
import bdseriestv.Series;
import bdseriestv.SeriesJpaController;
import java.util.List;

public class JPAVista {

    public static void mostrarSeries(SeriesJpaController daoSeries) {

        System.out.println("==".repeat(40));
        System.out.println("== Muestra series ==");
        System.out.println("==".repeat(40));

        List<Series> lista = daoSeries.findSeriesEntities();

        String lineaSeparadora = "+" + "-".repeat(4)
                + "+" + "-".repeat(22)
                + "+" + "-".repeat(12)
                + "+" + "-".repeat(10) + "+";

        System.out.println(lineaSeparadora);
        System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", "ID", "Titulo", "TV", "Duracion");
        System.out.println(lineaSeparadora);

        for (Series serie : lista) {
            System.out.printf("| %-2s | %-10s | %-40s | %-10s |%n", serie.getCodigo(),serie.getTitulo(),serie.getCanaltv(),serie.getDuracion() );
        }

    }
    
    public static void mostrarCanales(CanalestvJpaController daoCanales) {

        System.out.println("==".repeat(40));
        System.out.println("== Muestra series ==");
        System.out.println("==".repeat(40));

        List<Canalestv> lista = daoCanales.findCanalestvEntities();

        String lineaSeparadora = "+" + "-".repeat(12)
                + "+" + "-".repeat(22);

        System.out.println(lineaSeparadora);
        System.out.printf("| %-10s | %-20s | %n", "Codigo", "Nombre");
        System.out.println(lineaSeparadora);

        for (Canalestv canal : lista) {
            System.out.printf("| %-8s | %-18s | %n",canal.getCodigo(),canal.getNombre());
        }
    }

    

}
