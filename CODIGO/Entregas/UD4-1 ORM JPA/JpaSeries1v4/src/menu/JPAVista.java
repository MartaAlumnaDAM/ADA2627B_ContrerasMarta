package menu;

import bdseries.Series;
import bdseries.SeriesJpaController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class JPAVista {

    public static void verSeries(SeriesJpaController daoSeries) {

        System.out.println("===========================");
        System.out.println("Muestra series");
        System.out.println("===========================");

        List<Series> lista = daoSeries.findSeriesEntities();

        String lineaSeparadora = "+" + "-".repeat(4)
                + "+" + "-".repeat(22)
                + "+" + "-".repeat(12)
                + "+" + "-".repeat(10) + "+";

        System.out.println(lineaSeparadora);
        System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", "ID", "Titulo", "TV", "Duracion");
        System.out.println(lineaSeparadora);

        for (Series serie : lista) {
            System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", serie.getCodigo(), serie.getTitulo(), serie.getTv(), serie.getDuracion());
        }

        System.out.println(lineaSeparadora);
    }

    public static void agregaSeries(SeriesJpaController daoSeries) {

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

    public static void seriePorTitulo(SeriesJpaController daoSeries) {

        System.out.println("===========================");
        System.out.println("Busca serie que coincida con titulo");
        System.out.println("===========================");

        System.out.print("Introduzca el título: ");
        Scanner teclado = new Scanner(System.in);
        String titulo = teclado.nextLine();

        EntityManager em = null;
        try {
            em = daoSeries.getEntityManager();
            TypedQuery<Series> consultaSeries
                    = em.createNamedQuery("Series.findByLikeTitulo", Series.class);
            consultaSeries.setParameter("titulo", "%" + titulo + "%");
            List<Series> lista = consultaSeries.getResultList();

            String lineaSeparadora = "+" + "-".repeat(4)
                    + "+" + "-".repeat(22)
                    + "+" + "-".repeat(12)
                    + "+" + "-".repeat(10) + "+";

            System.out.println(lineaSeparadora);
            System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", "ID", "Titulo", "TV", "Duracion");
            System.out.println(lineaSeparadora);

            for (Series serie : lista) {
                System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", serie.getCodigo(), serie.getTitulo(), serie.getTv(), serie.getDuracion());
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public static void seriePorDuracion(SeriesJpaController daoSeries) {

        System.out.println("===========================");
        System.out.println("Busca serie por duracion");
        System.out.println("===========================");

        Scanner teclado = new Scanner(System.in);
        int desde = 0;
        int hasta = 0;

        try {

            System.out.print("Introduzca el intervalo de duración -> Desde: ");
            desde = Integer.parseInt(teclado.nextLine().trim());

            System.out.print("Hasta: ");
            hasta = Integer.parseInt(teclado.nextLine().trim());
            
        } catch (NumberFormatException e) {
            System.out.println("Error: debes introducir números enteros válidos");
            return;
        }

        EntityManager em = null;
        try {
            em = daoSeries.getEntityManager();
            Query query
                    = em.createQuery("SELECT s FROM Series s WHERE s.duracion BETWEEN :desde AND :hasta");
            query.setParameter("desde", desde);
            query.setParameter("hasta", hasta);

            List<Series> lista = query.getResultList();

            String lineaSeparadora = "+" + "-".repeat(4)
                    + "+" + "-".repeat(22)
                    + "+" + "-".repeat(12)
                    + "+" + "-".repeat(10) + "+";

            System.out.println(lineaSeparadora);
            System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", "ID", "Titulo", "TV", "Duracion");
            System.out.println(lineaSeparadora);

            for (Series serie : lista) {
                System.out.printf("| %-2s | %-20s | %-10s | %-8s |%n", serie.getCodigo(), serie.getTitulo(), serie.getTv(), serie.getDuracion());
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
