package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC08CreateTry {

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

            // Crear Statement del CREATE TABLE
            String sentenciaSQL = "CREATE TABLE personas ( "
                    + "codigo VARCHAR(4) PRIMARY KEY, "
                    + "nombre VARCHAR(50), "
                    + "email VARCHAR(40) " + ");";

            try (Connection con = DriverManager.getConnection(url, usuario, password);
                    Statement statement = con.createStatement();) {

                // Execute
                statement.executeUpdate(sentenciaSQL);
                System.out.println("Tabla personas creada");

            } catch (SQLException ex) {

                System.out.println("Error en sentencia CREATE de SQL.");
                System.out.println(ex.getErrorCode() + " " + ex.getMessage());

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC08CreateTry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
