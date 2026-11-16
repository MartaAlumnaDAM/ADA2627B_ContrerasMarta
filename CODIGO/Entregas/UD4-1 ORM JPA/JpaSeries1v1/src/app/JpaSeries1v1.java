/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import series.Series;
import series.SeriesJpaController;

/**
 *
 * @author marta
 */
public class JpaSeries1v1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EntityManagerFactory emf =
               Persistence.createEntityManagerFactory("JpaSeries1v1PU");
    
        SeriesJpaController dao=new SeriesJpaController(emf);
        List<Series> lista=dao.findSeriesEntities();
        for (Series ser : lista) {
            System.out.println(ser.toString());
        }
        
        emf.close();
    }
    }
    

