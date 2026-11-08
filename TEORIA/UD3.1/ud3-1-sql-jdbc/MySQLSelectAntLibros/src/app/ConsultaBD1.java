package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD1 {

    public static void main(String[] args) {

        // Conexión a la BD
        String url;
        url = "jdbc:mysql://localhost:3306/biblioteca";
        url += "?zeroDateTimeBehavior=convertToNull";
        url += "&autoReconnect=true";
        url += "&useSSL=false";
        url += "&useUnicode=true";
        url += "&serverTimezone=UTC";

        String usuario = "root";
        String password = "1234";

        // Crear Statement de la Consulta
        String sentenciaSQL = "SELECT * FROM libros ORDER BY id";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (   Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement(); 
                    ResultSet rs = statement.executeQuery(sentenciaSQL);) {

                // Resulset
                System.out.println("+----+----------------------------------------------------+--------------------------------+");
                System.out.println("| ID | Título                                             | Autor                          |");
                System.out.println("+----+----------------------------------------------------+--------------------------------+");
                while (rs.next()) {
                    System.out.printf("| %2d |", rs.getInt("id"));
                    System.out.printf(" %-50s |", rs.getString("titulo"));
                    System.out.printf(" %-30s |", rs.getString("autor"));
                    System.out.println();
                }
                System.out.println("+----+----------------------------------------------------+--------------------------------+");

            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.toString());
            }
        } catch (ClassNotFoundException cE) {
            System.out.println("Excepción: " + cE.toString());
        }

    }
}
