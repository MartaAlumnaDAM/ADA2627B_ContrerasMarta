
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BDAccess01 {

    public static void main(String[] args) {
        try {
          
            // Cargar el driver de Microsoft Access 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String connectionUrl = "jdbc:ucanaccess://./datos/BD-Farmacia.mdb;memory=false";

            // Obtener la conexión
            Connection con = DriverManager.getConnection(connectionUrl);
         
            // La clase Statement contiene los métodos executeQuery y
            // executeUpdate para realizar consultas y actualizaciones
            Statement stmt = con.createStatement();

			// El método executeQuery devuelve un objeto ResultSet para poder
			// recorrer el resultado de la consulta utilizando un cursor.
			// Esta consulta obtiene todos los datos, todos los campos, 
			// (debido al SELECT *), almacenados en la tabla medicamentos.
            ResultSet rs = stmt.executeQuery("SELECT * from medicamentos");

            
            // Mientras queden datos
            System.out.printf("%-6s %-35s %7s %7s %3s\n",
                            "CÓDIGO", "NOMBRE", "PRECIO", "PVP", "UD");
            System.out.printf("%-6s %-35s %7s %7s %3s\n",
                            "------", "------", "------", "---", "--");
            while (rs.next()) {
                // Imprimir en la consola
                String codigo   = rs.getString("codigo");
                String nombre   = rs.getString("nombre");
                Double precio   = rs.getDouble("precio");
                Double pvp      = rs.getDouble("pvp");
                int unidades = rs.getInt("unidades");
                System.out.printf("%6s %-35s %7.2f %7.2f %3d\n",
                            codigo, nombre, precio, pvp, unidades);
            }
            rs.close();
            stmt.close();
            con.close();

       } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
       } catch (ClassNotFoundException cE) {
            System.out.println("Excepción: "+ cE.toString());
        }
    }

    
}
