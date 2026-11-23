package menu;

import bibliotecah2.Autores;
import bibliotecah2.AutoresJpaController;
import bibliotecah2.Libros;
import bibliotecah2.LibrosJpaController;
import jakarta.persistence.*;
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

    static void librosPorAutor(LibrosJpaController daoLibros) {

        System.out.println("===========================");
        System.out.println("Buscar libros que contengan título");
        System.out.println("===========================");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el título: ");
        String titulo = teclado.nextLine();

        try (EntityManager em = daoLibros.getEntityManager()) {
            String q = "SELECT l FROM Libros l WHERE l.titulo LIKE '%" + titulo + "%'";
            Query query = em.createQuery(q);
            verLibros(query.getResultList());
        }
    }

    static void autorPorCodigo(AutoresJpaController daoAutores) {

        System.out.println("===========================");
        System.out.println("Buscar autor por código");
        System.out.println("===========================");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el código: ");
        String cod = teclado.nextLine();

        try (EntityManager em = daoAutores.getEntityManager();) {
            TypedQuery<Autores> consultaAutor
                    = em.createNamedQuery("Autores.findByCod", Autores.class);
            consultaAutor.setParameter("cod", cod);
            List<Autores> lista = consultaAutor.getResultList();
            verAutores(lista);
        }
    }

    static void editarLibro(
            LibrosJpaController daoLibros,
            AutoresJpaController daoAutores
            ) {
        System.out.println("===========================");
        System.out.println("Editar libro");
        System.out.println("===========================");

        Scanner teclado = new Scanner(System.in);
        Libros l = null;
        do {
            System.out.print("Introduzca el código: ");
            Integer id = Integer.parseInt(teclado.nextLine());
            l = daoLibros.findLibros(id);
            if (l == null) {
                System.out.printf("El libro con código %s no existe\n", id);
            }             
        } while (l == null);

        System.out.printf("El título actual es %s\n", l.getTitulo());
        System.out.print("Introduzca el nuevo título: ");
        String titulo = teclado.nextLine();        
        l.setTitulo(titulo);
        
        System.out.printf("El autor actual es %s\n", l.getCodautor().getNombre());
        System.out.print("Introduzca el nuevo autor: ");
        String autor = teclado.nextLine();
        
        try (EntityManager em = daoAutores.getEntityManager()) {
            TypedQuery<Autores> q = em.createNamedQuery("Autores.findByNombre", Autores.class);
            q.setParameter("nombre", autor);
            List<Autores> autorEncontrado = q.getResultList();
            l.setCodautor(autorEncontrado.get(0));
        }
               
        try {
            daoLibros.edit(l);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }

    static void autorYTotalLibros(LibrosJpaController daoLibros) {
        System.out.println("===========================");
        System.out.println("Autores y total de libros");
        System.out.println("===========================");

        try (EntityManager em = daoLibros.getEntityManager()) {
            String q = """
                       SELECT l.codautor.nombre, COUNT(l.id) as totalLibros
                       FROM Libros l 
                       GROUP BY l.codautor.cod
                       """;
            Query query = em.createQuery(q);
            List<Object[]> rs = query.getResultList();
            for (Object[] r : rs) {
                String nombre = (String)r[0];
                Long totalLibros = (Long)r[1];
                System.out.printf("%s %d\n", nombre, totalLibros);
            }
            
        }
    }

}
