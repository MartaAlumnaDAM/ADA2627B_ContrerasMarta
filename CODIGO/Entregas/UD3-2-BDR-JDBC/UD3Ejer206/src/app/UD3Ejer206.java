package app;

import java.sql.*;
import java.util.Scanner;

/**
 * @author marta
 */
public class UD3Ejer206 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url;
            url = "jdbc:mysql://localhost:3306/bdapps";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
            url += "&serverTimezone=UTC";
            String user = "root";
            String password = "1234";
            
            String sentenciaSql = "INSERT INTO programas (codigo, nombre, carpeta) VALUES(?,?,?);";
            
            try (Scanner teclado = new Scanner(System.in)) {
                
                // Solicita datos al usuario
                System.out.println("-".repeat(5) + "Introduzca los datos del programa" + "-".repeat(5));
                System.out.print("Nombre del programa: ");
                String nombre = teclado.nextLine();
                
                System.out.print("Carpeta que lo contendrá: ");
                String carpeta = teclado.nextLine();

                try (Connection con = DriverManager.getConnection(url, user, password);
                     PreparedStatement pstmt = con.prepareStatement(sentenciaSql)) {
                    
                    Boolean guardado = false;
                    
                    while (!guardado) {
                        System.out.print("Introduzca el código del programa (número entero): ");
                        
                        try {
                            int codigo = Integer.parseInt(teclado.nextLine());
                            
                            pstmt.setInt(1, codigo);
                            pstmt.setString(2, nombre);
                            pstmt.setString(3, carpeta);
                           
                            pstmt.executeUpdate();
                            
                            // Si no salta excepción, el registro se ha guardado correctamente
                            System.out.println("¡Programa guardado con éxito!");
                            guardado = true; 
                            
                        } catch (SQLIntegrityConstraintViolationException e) {
                            // Captura específica si el código (Primary Key) ya existe
                            System.out.println("Error: El código ya existe en la base de datos. Inténtelo de nuevo.");
                        } catch (NumberFormatException e) {
                            // Captura adicional por si el usuario introduce letras en vez de números en el código
                            System.out.println("Error: El código debe ser un número entero válido. Inténtelo de nuevo.");
                        }
                    }

                } catch (SQLException se) {
                    // Controla errores generales de la base de datos (como fallos de red o sintaxis SQL)
                    se.printStackTrace();
                }
            }

        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
    }

}
