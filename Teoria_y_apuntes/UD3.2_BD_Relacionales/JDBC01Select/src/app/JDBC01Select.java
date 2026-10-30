
package app;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

public class JDBC01Select { 
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
    
    // Crear Statement de la Consulta
    String sentenciaSQL = "SELECT titulo, autor FROM libros"; 
    Statement statement = con.createStatement(); 

    // Resulset
    ResultSet rs = statement.executeQuery(sentenciaSQL);
    System.out.printf("%-60s %-60s\n", "Título","Autor");
    System.out.print("------------------------------------------------------------"); 
    System.out.print(" ");
    System.out.print("------------------------------------------------------------"); 
    System.out.print("\n");
    while (rs.next()) { 
        System.out.printf("%-60s %-60s\n", rs.getString("titulo"), rs.getString("autor"));
    } 
    
    // Cerrar objetos
    rs.close(); 
    statement.close();
    con.close(); 
  } 
  
  
}
