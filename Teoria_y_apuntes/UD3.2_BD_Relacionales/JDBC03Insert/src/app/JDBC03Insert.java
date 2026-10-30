package app;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Statement; 

public class JDBC03Insert { 
  public static void main(String[] args) 
                     throws ClassNotFoundException, SQLException { 

    // Conexión a la BD
    String url;
    url = "jdbc:mysql://localhost:3306/biblioteca";
    url +="?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC"; 

    String usuario = "root"; 
    String password = "1234"; 

    Class.forName("com.mysql.cj.jdbc.Driver"); 
    Connection con = DriverManager.getConnection(url, usuario, password);
    
    // Crear Statement del Insert
    String sentenciaSQL = "INSERT INTO libros (titulo, autor) VALUES "+ 
               "('La metamorfosis', 'Franz Kafka'), "+ 
               "('Romeo y Julieta','William Shakespeare');"; 
    Statement statement = con.createStatement(); 

    // Execute
    int cantidad = statement.executeUpdate(sentenciaSQL);
    statement.close();
    
    System.out.println("Datos insertados: " + cantidad);


    // Cerrar conexión
    con.close(); 
  } 
}
