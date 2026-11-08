package app;

import java.sql.*;
import java.util.ArrayList;
/**
 * @author marta
 */
public class UD3Ejer205 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url;
            url = "jdbc:mysql://localhost:3306/bdapps";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
            url += "&serverTimezone=UTC";
            String user = "root";
            String password = "1234";

            String sentenciaSql = "SELECT codigo,nombre,carpeta FROM programas";
            
            ArrayList<Programa> programas = new ArrayList<>();
            
            try (Connection con = DriverManager.getConnection(url, user, password); 
                    Statement statement = con.createStatement()) {
                    ResultSet rs = statement.executeQuery(sentenciaSql);
                
                while(rs.next()){
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String carpeta = rs.getString("carpeta");
                    
                    Programa prog = new Programa(codigo,nombre,carpeta);
                    
                    programas.add(prog);
                }
                
                System.out.println("Contenido del ArrayList<Programa>");
                
                for(Programa p : programas){
                    if(p.getCarpeta().startsWith("C")){
                        System.out.println(p.toJson());
                    }
                    else{System.out.println("");}
                }
               
                
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.toString());
            }

        } catch (ClassNotFoundException ce) {
            System.out.println("Excepcion: " + ce.toString());
        
    }
    }
    
}
