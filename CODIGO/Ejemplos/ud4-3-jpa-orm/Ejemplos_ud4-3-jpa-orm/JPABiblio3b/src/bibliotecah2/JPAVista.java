package bibliotecah2;

import java.util.List;

public class JPAVista {

    public static void verLibrosFind(LibrosJpaController daoLibros) {
        System.out.println("Mostrando todos los libros:");
        System.out.println("===========================");

        List<Libros> lista = daoLibros.findLibrosEntities();
        for (Libros libro : lista) {
            System.out.println(libro.getId() + ": " + libro.getTitulo()
                    + ", de " + libro.getCodautor().getNombre());
        }
    }

    public static void verAutores(AutoresJpaController daoAutores) {

        System.out.println("Mostrando todos los autores y sus libros:");
        System.out.println("=========================================");

        List<Autores> lista = daoAutores.findAutoresEntities();
        for (Autores autor : lista) {
            System.out.println(autor.getNombre()
                    + " (" + autor.getCod() + "). Libros: ");
            for (Libros lib : autor.getLibrosCollection()) {
                System.out.println(" => " + lib.getTitulo());
            }
        }

    }
}