package bibliotecah2;

import java.util.List;
import java.util.Scanner;

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

    public static void addLibro(
            AutoresJpaController daoAutores,
            LibrosJpaController daoLibros) {
        
        Integer idlibro = 0;
        String titulo;
        String codAutor;
        Autores autor;

        System.out.println("===========================");
        System.out.println("Añadir un Libro");
        System.out.println("===========================");

        // Java - Leer datos
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca el titulo: ");
        titulo = teclado.nextLine();

        System.out.print("Introduzca el código del autor: ");
        codAutor = teclado.nextLine();

        // Java - Cargar datos en un objeto 
        Libros libro = new Libros();
        libro.setId(idlibro);
        libro.setTitulo(titulo);

        autor = daoAutores.findAutores(codAutor);

        if (autor != null) {
            libro.setCodautor(autor);
            daoLibros.create(libro);
        } else {
            System.out.println("El Autor " + codAutor + " no existe");
        }

    }
}
