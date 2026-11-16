package app;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Statement; 
import java.sql.ResultSet; 

public class JDBC06Function { 
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

    // Execute
    Statement statement = con.createStatement(); 
    String consulta = "select totallibros()"; 

    ResultSet rs = statement.executeQuery(consulta); 
    rs.next(); 
    System.out.println("El total de libros es: " + rs.getInt(1));

    // Cerrar objetos
    rs.close();
    statement.close();
    con.close(); 
  } 
}
