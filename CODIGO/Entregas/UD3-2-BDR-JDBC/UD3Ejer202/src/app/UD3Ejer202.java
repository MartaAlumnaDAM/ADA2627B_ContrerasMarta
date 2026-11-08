package app;

import java.sql.*;

/**
 *
 * @author marta
 */
public class UD3Ejer202 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url;
            url = "jdbc:mysql://localhost:3306/bdapps";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
            url += "&serverTimezone=UTC";
            String usuario = "root";
            String password = "1234";

            String sentenciaSQL = "CREATE TABLE ejecuciones ( "
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "codprograma VARCHAR(5), "
                    + "fecha DATE, "
                    + "usuario VARCHAR(40)"
                    + ");";

            try (Connection con = DriverManager.getConnection(url, usuario, password);
                    Statement statement = con.createStatement()) {
                
                statement.executeUpdate(sentenciaSQL);
                System.out.println("Tabla 'ejecuciones' creada");

                
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.toString());
            }

        } catch (ClassNotFoundException ce) {
            System.out.println("Excepcion: " + ce.toString());
        }
    }

}
