package menu;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import packUtils.Colores;

public class Opciones {

    private static Connection conexion = null;     // Conexion a la BD 

    // ************************************************************
    public static Boolean IsConectado() {
        Boolean resul = false;
        try {
            resul = (conexion != null) && (conexion.isValid(1000)); //System.out.println("Conectado");
            //System.out.println("NO conectado");
        } catch (SQLException e) {
            ErrorSql(e);

        } catch (Exception e) {
            ErrorGeneral(e);
        } // try         
        return resul;
    }

    // ************************************************************
    public static void ConectarMySQL(String pBD, String pUsuario, String pPassword) {
        try {
            if (!IsConectado()) {
                // Selecionar y cargar el Driver en Memoria
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establecer la conexion con la BD
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + pBD
                        + "?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useSSL=false&serverTimezone=UTC",
                        pUsuario, pPassword);
                if (IsConectado()) {
                    System.out.println("Conectado a " + conexion.getMetaData().getDatabaseProductName());
                }
            } else {
                System.out.println("YA está conectado a " + conexion.getMetaData().getDatabaseProductName());
            }
        } catch (SQLException e) {
            ErrorSql(e);
        } catch (Exception e) {
            ErrorGeneral(e);
        } // try         
    }

    // ************************************************************
    public static void Desconectar() {
        try {
            if (IsConectado()) {
                //Cerrar conexion
                String tipoBD = conexion.getMetaData().getDatabaseProductName();
                conexion.close();
                if (conexion.isClosed()) {
                    System.out.println("Desconectado de " + tipoBD);
                } else {
                    System.out.println("Error al desconectar");
                }
            } else {
                System.out.println("NO está conectado");
            }
        } catch (SQLException e) {
            ErrorSql(e);
        } catch (Exception e) {
            ErrorGeneral(e);
        } // try          
    }

    private static void ErrorSql(SQLException e) {
        System.out.println(Colores.LETRA_ROJO + Colores.FONDO_BLANCO + "ERROR: " + e.getErrorCode() + " " + e.getMessage());
    }

    private static void ErrorGeneral(Exception e) {
        System.out.println(Colores.LETRA_ROJO + Colores.FONDO_BLANCO + "ERROR: " + e);
    }


    /* ****************************************************************** */
    public static void mostrarLibros() {

        String sentenciaSQL = "SELECT id, titulo, autor FROM libros";

        try (Statement statement = conexion.createStatement();
                ResultSet rs = statement.executeQuery(sentenciaSQL);) {

            System.out.print("+----+----------------------------------------------------");
            System.out.println("+--------------------------------+");
            System.out.printf("| ID | %-50s | %-30s |\n", "Título", "Autor");
            System.out.print("+----+----------------------------------------------------");
            System.out.println("+--------------------------------+");
            while (rs.next()) {
                System.out.printf("| %2d | %-50s | %-30s |\n",
                        rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
            }
            System.out.print("+----+----------------------------------------------------");
            System.out.println("+--------------------------------+");

        } catch (SQLException ex) {
            ErrorSql(ex);
        }

    }

    /* ****************************************************************** */
    public static void addLibro() {
        try {
            // Leer datos de la nueva persona
            Scanner teclado = new Scanner(System.in);

            System.out.println("ALTA DE LIBRO");
            System.out.println("----------------");
            System.out.print("Introduce el título: ");
            String titulo = teclado.nextLine();
            System.out.print("Introduce el autor.: ");
            String autor = teclado.nextLine();

            // Insertar datos
            String sentenciaSQL = "INSERT INTO libros (titulo, autor) VALUES ("
                    + "'" + titulo + "','" + autor + "')";

            try (Statement statement = conexion.createStatement()) {
                int cantidad = statement.executeUpdate(sentenciaSQL);
                if (cantidad != 1) {
                    System.out.println("Error: registro no insertado");
                }
            } catch (SQLException ex) {
                ErrorSql(ex);
                System.out.println("Error en sentencia INSERT.");
                System.out.println(ex.getErrorCode() + " " + ex.getMessage());
            }
        } catch (Exception e) {
            ErrorGeneral(e);
        }
    }

    /* ****************************************************************** */
    public static void buscaLibro() {

        try {
            
            // Declarar objetos
            boolean encontrada = false;
        
            // Leer nombre  de la nueva persona
            Scanner teclado = new Scanner(System.in);
            System.out.println("BUSCAR LIBRO POR AUTOR");
            System.out.println("----------------------");
            System.out.print("Introduce el autor: ");
            String autor = teclado.nextLine();

            // Buscar libro
            // Crear Statement de la Consulta
            String sentenciaSQL = "SELECT id, titulo, autor FROM libros WHERE autor LIKE '%" + autor + "%'";
            try (Statement statement = conexion.createStatement();
                    ResultSet rs = statement.executeQuery(sentenciaSQL);) {

                while (rs.next()) {
                    if (!encontrada) {
                        System.out.print("+----+----------------------------------------------------");
                        System.out.println("+--------------------------------+");
                        System.out.printf("| ID | %-50s | %-30s |\n", "Título", "Autor");
                        System.out.print("+----+----------------------------------------------------");
                        System.out.println("+--------------------------------+");
                        encontrada = true;
                    }
                    System.out.printf("| %2d | %-50s | %-30s |\n",
                            rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
                }
                if (encontrada) {
                    System.out.print("+----+----------------------------------------------------");
                    System.out.println("+--------------------------------+");
                }

            } catch (SQLException ex) {
                ErrorSql(ex);
            }

            // Mostrar resultado
            if (!encontrada) {
                System.out.println("No existe Libro con el autor: " + autor);
            }

        } catch (Exception e) {
            ErrorGeneral(e);
        }

    }
}
