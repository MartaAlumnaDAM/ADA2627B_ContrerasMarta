package app;

import clases.Libro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC01SelectORM {

    public static void main(String[] args) {

        ArrayList<Libro> libros = ORMLibros();
        mostrarLibros(libros);

    }

    public static ArrayList<Libro> ORMLibros() {

        ArrayList<Libro> libros = new ArrayList<>();
        try {
            // Conexión a la BD
            String url;

            url = "jdbc:mysql://localhost:3306/biblioteca";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";

            String usuario = "root";
            String password = "1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            String sentenciaSQL = "SELECT * FROM libros";
            try (
                    Connection con = DriverManager.getConnection(url, usuario, password); Statement statement = con.createStatement(); ResultSet rs = statement.executeQuery(sentenciaSQL);) {

                while (rs.next()) {
                    Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
                    libros.add(libro);
                }

            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode() + " " + ex.getMessage());
            }
        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }

        return libros;
    }

    public static void mostrarLibros(ArrayList<Libro> libros) {
        String linea = String.format("+-%s-+-%s-+-%s-+\n",
                "-".repeat(2),
                "-".repeat(50),
                "-".repeat(30));

        System.out.printf(linea);
        System.out.printf("| %-2s | %-50s | %-30s |%n", "ID", "TÍTULO", "AUTOR");
        System.out.printf(linea);
        for (Libro lib : libros) {
            System.out.printf("| %2d | %-50s | %-30s |%n",
                    lib.getId(),
                    lib.getTitulo(),
                    lib.getAutor());
        }
        System.out.printf(linea);
    }

}
