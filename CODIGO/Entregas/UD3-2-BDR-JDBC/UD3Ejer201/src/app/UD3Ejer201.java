package app;

import java.sql.*;

public class UD3Ejer201 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url;
            url = "jdbc:mysql://localhost:3306/bdtasks";
            String usuario = "root";
            String password = "1234";

            String sentenciaSQL = "SELECT codigo, descripcion, fecha_prevista,terminada FROM tasks";

            try (Connection con = DriverManager.getConnection(url, usuario, password); Statement statement = con.createStatement(); ResultSet rs = statement.executeQuery(sentenciaSQL);) {

                String lineaDivisoria = String.format("+%s+%s+%s+%s+%n", "-".repeat(8),"-".repeat(42),"-".repeat(16),"-".repeat(11));
                System.out.print(lineaDivisoria);
                System.out.printf("| %-6s | %-40s | %-14s | %-9s |%n",
                            "Codigo", "Descripcion", "Fecha prevista", "Terminada");
                while (rs.next()) {
                  
                    int codigo = rs.getInt("codigo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fecha_prevista");
                    Boolean terminada = rs.getBoolean("terminada");
                    String tareaTerminada = terminada ? "SI" : "NO";
                    
                    System.out.printf(" %-8d %-44s %-16s %-13s %n",codigo,descripcion,fecha,tareaTerminada);
                }

            } catch (SQLException se) {
                se.printStackTrace();
            }

        } catch (ClassNotFoundException ce) {
            System.out.println("MySQL no accesible");
        }

    }
}
