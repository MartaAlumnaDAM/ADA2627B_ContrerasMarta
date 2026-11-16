package app;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement; 

public class JDBC02Create { 
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
    
    // Crear Statement del CREATE TABLE
    String sentenciaSQL = "CREATE TABLE personas ( "+ 
               "codigo VARCHAR(4) PRIMARY KEY, "+ 
               "nombre VARCHAR(50), "+ 
               "email VARCHAR(40) "+ ");"; 
    Statement statement = con.createStatement(); 

    // Execute
    statement.executeUpdate(sentenciaSQL);
    statement.close();
    
    System.out.println("Tabla personas creada");

    
    // Cerrar conexión
    con.close(); 
  } 
}
