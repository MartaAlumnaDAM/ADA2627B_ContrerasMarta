
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQL01 {
    public static void main(String[] args) {
      try {
         // Cargar el driver de mysql
         Class.forName("com.mysql.cj.jdbc.Driver");

         // Cadena de conexión a MySQL
         String conURL = "jdbc:mysql://localhost?user=root&password=1234&useSSL=false&serverTimezone=UTC";

         // Obtener la conexión
         Connection con = DriverManager.getConnection(conURL);
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT version() as versionmysql");
         if (rs.next()) {
            System.out.println("VERSIÓN DE MYSQL = "+rs.getString("versionmysql"));
         } else {
            System.out.println("Consulta sin resultados"); 
         }
         rs.close();
         stmt.close();
         
         // Cerrar la conexión
         con.close();

      } catch (SQLException e) {
         System.out.println("SQL Exception: " + e.toString());
      } catch (ClassNotFoundException cE) {
         System.out.println("Exception: " + cE.toString());
      }  
    }
    
}
