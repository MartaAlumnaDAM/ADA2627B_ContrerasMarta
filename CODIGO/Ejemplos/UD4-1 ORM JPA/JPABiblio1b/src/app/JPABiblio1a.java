package app;

import bibliotecah.Libros;
import bibliotecah.LibrosJpaController;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author marta
 */
public class JPABiblio1a {
    
    public static void verLibrosFind(LibrosJpaController dao) {
        System.out.println("Mostrando todos los libros:");
        List<Libros> lista = dao.findLibrosEntities();
        for (Libros libro : lista) {
            System.out.println(libro.getId() + ": " + libro.getTitulo()
                    + ", de " + libro.getAutor());
        }
    }
    

    public static void main(String[] args) {
        
        EntityManagerFactory emf =
               JPAUtil.getEntityManagerFactory();
    
        LibrosJpaController dao = new LibrosJpaController(emf);
        
        List<Libros> lista = dao.findLibrosEntities();
        
        for (Libros lib : lista) {
            //System.out.println(lib.toString());
            System.out.println(lib.getId() + ": " + lib.getTitulo() + ", de " + lib.getAutor());
        }
        
        emf.close();
    }
    
}
