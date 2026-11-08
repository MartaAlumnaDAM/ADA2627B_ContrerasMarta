package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBC04Prepare {

    public static void main(String[] args) {

        try {
            String url;
            url = "jdbc:mysql://localhost:3306/biblioteca";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
            String usuario = "root";
            String password = "1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            String sentenciaSQL = "SELECT titulo, autor FROM libros WHERE autor = (?) ";

            try (Connection con = DriverManager.getConnection(url, usuario, password); PreparedStatement pStatement = con.prepareStatement(sentenciaSQL);) {
                // Conexión a la BD

                // Crear Statement de la Consulta
                //int col = 1;
                String autor = "William Shakespeare, 'Julio Verne'";
                pStatement.setString(1, autor);

                // Resulset
                // Hacer el resulset reutilizable
                 
                try (ResultSet rs = pStatement.executeQuery(); // Aquí sin parámetros
                        ) {
                    
                    System.out.printf("%-60s %-60s\n", "Título", "Autor");
                    System.out.print("------------------------------------------------------------");
                    System.out.print(" ");
                    System.out.print("------------------------------------------------------------");
                    System.out.println();
                    while (rs.next()) {
                        System.out.printf("%-60s %-60s\n", rs.getString("titulo"), rs.getString("autor"));
                    }
                } catch (SQLException sQLException) {
                }

                // Cerrar objetos
                //rs.close();
                pStatement.close();
                con.close();
            } catch (Exception ex) {
                System.getLogger(JDBC04Prepare.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

        } catch (ClassNotFoundException ex) {
            System.getLogger(JDBC04Prepare.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

}
