/*
* @author marta
 */
package app;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import utils.JSONUtils;
import java.io.*;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UD2EjerJson1404fromDAT {

    public static void main(String[] args) {

        /*---- Creamos archivo binario ----*/
        String archivo = "./datos/alumnos.dat";
        ArrayList<Alumno> alumnos = new ArrayList<>();

        try (FileOutputStream foStream = new FileOutputStream(archivo); DataOutputStream doStream = new DataOutputStream(foStream);) {

            doStream.writeUTF("1|Luis Pérez|Alicante|3.4|6.2|6.8");
            doStream.writeUTF("2|Ana García|Elche|4.3|7.5");
            doStream.writeUTF("3|Juan González|Elda|7.7|9.3|8.4");

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        /*---- Lee el archivo y crea cada objeto alumno ----*/
        try (FileInputStream foStream = new FileInputStream(archivo); DataInputStream doStream = new DataInputStream(foStream);) {

            while (true) {
                String linea = doStream.readUTF();

                String[] partes = linea.split("\\|");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String ciudad = partes[2];
                ArrayList<Double> notas = new ArrayList<>();

                for (int i = 3; i < partes.length; i++) {
                    notas.add(Double.parseDouble(partes[i]));
                }

                Alumno alumno = new Alumno(id, nombre, ciudad, notas);
                alumnos.add(alumno);
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        System.out.println("");

        /* ---- Recorre el array de alumnos para crear el JSONArray ----*/
        System.out.println("Listado de Alumnos (ArrayList");
        System.out.println("---".repeat(40));

        try {

            JSONArray jArrayAlumnos = new JSONArray();

            for (Alumno alumno : alumnos) {
                JSONObject jAlumno = new JSONObject();
                jAlumno.put("id", alumno.getId());
                jAlumno.put("nombre", alumno.getNombre());
                jAlumno.put("ciudad", alumno.getCiudad());

                System.out.println(alumno.getNombre() + " - " + alumno.getCiudad());

                JSONArray jArrayNotas = new JSONArray();
                for (double nota : alumno.getNotas()) {
                    jArrayNotas.put(nota);
                }

                jAlumno.put("notas", jArrayNotas);

                jArrayAlumnos.put(jAlumno);
                
            }
            
            /* Recorre y muestra por pantalla el JSONArray alumnos*/
            System.out.println("");
            System.out.println("Alumnos (JSON)");
            System.out.println("--".repeat(40));
            System.out.println(jArrayAlumnos.toString(2));

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        
    }
}
