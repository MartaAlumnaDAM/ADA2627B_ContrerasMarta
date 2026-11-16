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

    public static void main(String[] args) {
        EntityManagerFactory emf =
               Persistence.createEntityManagerFactory("JPABiblio1PU");
    
        LibrosJpaController dao=new LibrosJpaController(emf);
        List<Libros> lista=dao.findLibrosEntities();
        for (Libros lib : lista) {
            System.out.println(lib.toString());
        }
        
        emf.close();
    }
    
}
