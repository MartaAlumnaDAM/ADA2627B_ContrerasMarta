package menu;

import bibliotecah2.Autores;
import bibliotecah2.AutoresJpaController;
import bibliotecah2.Libros;
import bibliotecah2.LibrosJpaController;
import java.util.List;
import java.util.Scanner;

public class JPAVista {

    public static void verLibros(List<Libros> libros) {
        for (Libros libro : libros) {
            System.out.printf(
                    "%s %s\n",
                    libro.getCodautor().getNombre(),
                    libro.getTitulo());
        }
    }

    public static void verAutores(List<Autores> autores) {
        for (Autores a : autores) {
            System.out.printf("%s:\n", a.getNombre());
            for (Libros l : a.getLibrosCollection()) {
                System.out.printf("\t- %s\n", l.getTitulo());
            }
        }
    }

    static void crearLibro(
            AutoresJpaController daoAutores,
            LibrosJpaController daoLibros) {
        System.out.println("===========================");
        System.out.println("Añadir un libro");
        System.out.println("===========================");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el título: ");
        String titulo = teclado.nextLine();
        System.out.print("Introduzca codigo autor: ");
        String codAutor = teclado.nextLine();
        
        Autores a = daoAutores.findAutores(codAutor);
        if (a != null) {
           Libros l = new Libros(titulo, a);
           daoLibros.create(l);
        } else {
            System.out.printf("El autor con código %s no existe, crealo desde el menú.\n", codAutor);
        }
    }

}
