package app;

import bibliotecah2.JPAUtil;
import bibliotecah2.Libros;
import bibliotecah2.LibrosJpaController;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class JPABiblio3a {

    public static void verLibrosFind(LibrosJpaController dao) {
        System.out.println("Mostrando todos los libros:");
        System.out.println("===========================");

        List<Libros> lista = dao.findLibrosEntities();
        for (Libros libro : lista) {
            System.out.println(libro.getId() + ": " + libro.getTitulo()
                    + ", de " + libro.getCodautor().getNombre());
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        LibrosJpaController daoLibros = new LibrosJpaController(emf);

        verLibrosFind(daoLibros);

        emf.close();
    }

}
