package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite01 {

    public static void main(String[] args) {
        // Conexión a la BD
        String url = "jdbc:sqlite:./datos/bddepartamentos.db";
        String usuario = null;
        String password = null;
        
        // Crear la Consulta
        String sentenciaSQL = "SELECT dept_no, dnombre, loc FROM departamentos";
        try {

            Class.forName("org.sqlite.JDBC");

            try (   Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement(); 
                    ResultSet rs = statement.executeQuery(sentenciaSQL);) {

                System.out.println("+----+-----------------+-----------------+");
                System.out.println("| DP | Nombre          | Loc             |");
                System.out.println("+----+-----------------+-----------------+");
                while (rs.next()) {
                    System.out.printf("| %2d |", rs.getInt("dept_no"));
                    System.out.printf(" %-15s |", rs.getString("dnombre"));
                    System.out.printf(" %-15s |", rs.getString("loc"));
                    System.out.println();
                }
                System.out.println("+----+-----------------+-----------------+");

            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.toString());
            }
        } catch (ClassNotFoundException cE) {
            System.out.println("Excepción: " + cE.toString());
        }
    }
}
