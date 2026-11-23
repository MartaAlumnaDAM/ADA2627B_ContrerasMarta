package menu;

import bdseriestv.Canalestv;
import bdseriestv.CanalestvJpaController;
import bdseriestv.Series;
import bdseriestv.SeriesJpaController;
import java.util.List;
import java.util.Scanner;

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
            System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", serie.getCodigo(),serie.getTitulo(),serie.getCanaltv().getNombre(),serie.getDuracion() );
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

    public static void agregaCanal(CanalestvJpaController daoCanales){
    
        System.out.println("==".repeat(40));
        System.out.println("Añadir un canal de TV");
        System.out.println("==".repeat(40));
        
        String codigo,titulo;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca el código del canal de TV: ");
        codigo = teclado.nextLine();
        
        Canalestv canal = daoCanales.findCanalestv(codigo);
        
        if(canal == null){
            
            System.out.println("Introduzca el título: ");
            titulo = teclado.nextLine();
            
            Canalestv newCanal = new Canalestv();
            newCanal.setCodigo(codigo);
            newCanal.setNombre(titulo);
            
            try {
                daoCanales.create(newCanal);
            } catch (Exception ex) {
                System.getLogger(JPAVista.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
        else{System.out.println("Ya existe un canal con el codigo " + codigo);}
        
        
    }

}
