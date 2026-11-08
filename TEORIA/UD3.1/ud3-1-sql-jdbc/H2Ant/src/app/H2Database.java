package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Database {

    public static void main(String[] args) {

        try {
            String url;

            Class.forName("org.h2.Driver");
            url = "jdbc:h2:./datos/dpto";
            String usuario = "sa";
            String password = null;

            String sentenciaSQL = "SELECT * FROM departamentos";
            try (   Connection con = DriverManager.getConnection(url, usuario, password); 
                    Statement statement = con.createStatement(); 
                    ResultSet rs = statement.executeQuery(sentenciaSQL);) {
                System.out.println("+----+----------------------+----------------------+");
                System.out.println("| ID | DEPARTAMENTO         | LOCALIDAD            |");
                System.out.println("+----+----------------------+----------------------+");
                while (rs.next()) {
                    System.out.printf("| %2d |", rs.getInt("dept_no"));
                    System.out.printf(" %-20s |", rs.getString("dnombre"));
                    System.out.printf(" %-20s |", rs.getString("loc"));
                    System.out.println();
                }
                System.out.println("+----+----------------------+----------------------+");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
