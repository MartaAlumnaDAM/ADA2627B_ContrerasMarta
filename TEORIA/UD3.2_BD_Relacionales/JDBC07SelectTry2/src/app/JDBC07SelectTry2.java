package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC07SelectTry2 {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conexión a la BD
            String url;
            url = "jdbc:mysql://localhost:3306/biblioteca";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
            url += "&serverTimezone=UTC";

            String usuario = "root";
            String password = "1234";

            String sentenciaSQL = "SELECT titlo, autor FROM libros";

            try (   Connection con = DriverManager.getConnection(url, usuario, password);
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery(sentenciaSQL);) {
                System.out.printf("%-60s %-60s\n", "Título", "Autor");
                System.out.print("------------------------------------------------------------");
                System.out.print(" ");
                System.out.print("------------------------------------------------------------");
                System.out.println();
                while (rs.next()) {
                    System.out.printf("%-60s %-60s\n",
                            rs.getString("titulo"),
                            rs.getString("autor"));
                }
                System.out.println("----------");
                System.out.println("Terminado!");
            } catch (SQLException se) {
                // se.printStackTrace(); 
                System.out.println("No se ha podido realizar el SELECT");
                switch (se.getErrorCode()) {
                    case 1054:
                        // Columna desconocida
                        System.out.println("ERROR: Columna desconocida");
                        System.out.println(se.getErrorCode() + " " + se.getMessage());
                        break;
                    case 1064:
                        // Error de sintaxis
                        System.out.println("ERROR de SINTAXIS");
                        System.out.println(se.getErrorCode() + " " + se.getMessage());
                        break;
                    default:
                        System.out.println(se.getErrorCode() + " " + se.getMessage());
                }

            }
        } catch (ClassNotFoundException ce) {
            // ce.printStackTrace(); 
            System.out.println("MySQL no accesible");
        }
    }

}
