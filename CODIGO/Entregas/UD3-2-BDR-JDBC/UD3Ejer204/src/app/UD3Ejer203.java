package app;

import java.sql.*;

/**
 *
 * @author marta
 */
public class UD3Ejer203 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url;
            url = "jdbc:mysql://localhost:3306/bdapps";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
            url += "&serverTimezone=UTC";
            String user = "root";
            String password = "1234";

            String updateProgramas = """
                                  UPDATE programas
                                  SET ocupacion = CASE codigo
                                    WHEN 1 THEN 3260000
                                    WHEN 2 THEN 510000
                                    WHEN 3 THEN 40000
                                  END
                                  WHERE codigo IN (1,2,3);
                                  """;

            String muestraProgramas = "SELECT * FROM programas";
            
            String limpiaEjecuciones = "TRUNCATE TABLE ejecuciones";
            
            String insertaEjecuciones = """
                                        INSERT INTO ejecuciones (codprograma, fecha, usuario) VALUES
                                        (1, '2026-11-02', 'Jorge'),
                                        (2, '2026-11-02', 'Mariana'),
                                        (3, '2026-11-02', 'Elena');
                                        """;
            
            String muestraEjecuciones = "SELECT * FROM ejecuciones";

            try (Connection con = DriverManager.getConnection(url, user, password); 
                    Statement statement = con.createStatement()) {

                //Actualiza tabla programas y muestra la tabla actualizada
                statement.executeUpdate(updateProgramas);
                System.out.println("Actualizada tabla 'programas'\n");
                System.out.print("-".repeat(10) + "Mostrando contenido de la tabla" + "-".repeat(10) + "\n");

                ResultSet rs = statement.executeQuery(muestraProgramas);

                System.out.printf("| %-6s | %-10s | %-30s | %-9s |%n",
                        "Codigo", "Nombre", "Carpeta", "Ocupacion");
                
                while (rs.next()) {
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String carpeta = rs.getString("carpeta");
                    int ocupacion = rs.getInt("ocupacion");
                    
                    System.out.printf("  %-6d   %-10s   %-30s  %-9d %n",
                       codigo, nombre, carpeta, ocupacion);
                }
                System.out.println("");
                
                //Inserta datos en tabla ejecuciones
                statement.execute(limpiaEjecuciones);
                statement.executeUpdate(insertaEjecuciones);
                System.out.println("Se han agregado registros a la tabla 'ejecuciones'.");
                System.out.print("-".repeat(10) + "Mostrando contenido de la tabla" + "-".repeat(10) + "\n");

                ResultSet rs1 = statement.executeQuery(muestraEjecuciones);

                System.out.printf("| %-6s | %-10s | %-30s | %-9s |%n",
                        "Id", "Codigo", "Fecha", "Usuario");
                
                while (rs1.next()) {
                    int id = rs1.getInt("id");
                    int codigo = rs1.getInt("codprograma");
                    String fecha = rs1.getString("fecha");
                    String usuario = rs1.getString("usuario");
                    
                    System.out.printf("  %-6d   %-10d   %-30s   %-9s  %n",
                       id, codigo, fecha, usuario);
                }
                
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.toString());
            }

        } catch (ClassNotFoundException ce) {
            System.out.println("Excepcion: " + ce.toString());
        
    }

}
}
