package app;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.CallableStatement; 
import java.sql.Types;

public class JDBC05Procedure { 
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
    CallableStatement cStmt = con.prepareCall("{call maximo(?,?,?)}");
    cStmt.setFloat(1, (float) 10.4);
    cStmt.setFloat(2, (float) 30.7);
    cStmt.registerOutParameter(3, Types.DECIMAL); 
    
    cStmt.execute(); 
    float resultado = cStmt.getFloat(3); 
    System.out.println("El máximo es: " + resultado);

    // Cerrar objetos
    cStmt.close();
    con.close(); 
  } 
}
