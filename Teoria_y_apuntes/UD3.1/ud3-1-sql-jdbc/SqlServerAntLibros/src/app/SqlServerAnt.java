package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerAnt {

    public static void main(String[] args) {

        // Crear variable para la cadena de conexión
        String hostName = "127.0.0.1";
        String port = "1433";
        String dbName = "biblioteca";
        String user = "sa";
        String password = "1234";

        String connectionUrl = String.format("jdbc:sqlserver://%s:%s;database=%s;"
                + "user=%s;password=%s;loginTimeout=30;encrypt=false;",
                hostName, port, dbName, user, password);

        String sentenciaSQL = "SELECT * FROM libros ORDER BY id";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (   Connection con = DriverManager.getConnection(connectionUrl); 
                    Statement statement = con.createStatement(); 
                    ResultSet rs = statement.executeQuery(sentenciaSQL);) {

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
