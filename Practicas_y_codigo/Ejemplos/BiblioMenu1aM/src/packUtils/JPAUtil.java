package packUtils;

import jakarta.persistence.*;

public class JPAUtil {
    public static EntityManagerFactory emf = null;
    public static EntityManagerFactory getEntityManagerFactory() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("BiblioMenu1aMPU");
            }
        } catch (Throwable t) {
            System.out.println("Error al iniciar el Entity Manager factory");
            t.printStackTrace();
            throw new ExceptionInInitializerError();
        }
        return emf;
    }
    
}