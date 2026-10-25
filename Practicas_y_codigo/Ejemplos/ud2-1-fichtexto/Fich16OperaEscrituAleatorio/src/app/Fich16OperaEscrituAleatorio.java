package app;

import java.io.*;

public class Fich16OperaEscrituAleatorio {

    private static final String FICHERO = "./datos/aleatorio2.bin";
    private static final int SIZE = 25;

    public static void aleatorioGraba(String s) {
        // Abrir y grabar registro al final del fichero
        try (RandomAccessFile miRAFile = new RandomAccessFile(FICHERO, "rw")) {

            // Añadir espacios hasta 25 caracteres
            if (s.length() < SIZE) {
                for (int i = s.length(); i < SIZE; i++) {
                    s = s + " ";
                }
            } else {
                s = s.substring(0, SIZE);
            }

            // Nos vamos al final del fichero
            miRAFile.seek(miRAFile.length());

            // Incorporamos la cadena al fichero
            miRAFile.writeBytes(s);

        } catch (FileNotFoundException e) {
            /* Archivo no encontrado */
            System.out.println(e.getMessage());
        } catch (IOException e) {
            /* Error al escribir */
            System.out.println(e.getMessage());
        } catch (Exception e) {
            /* Error general */
            System.out.println("Error en el tratamiento de los ficheros");
        }
    }

    public static void aleatorioNumRegistros() {
        // Abrir, mostrar número de registros
        try (RandomAccessFile miRAFile = new RandomAccessFile(FICHERO, "r")) {

            long num_registros = miRAFile.length() / SIZE;
            System.out.println("Num. de registros:" + num_registros);

        } catch (FileNotFoundException e) {
            /* Archivo no encontrado */
            System.out.println(e.getMessage());
        } catch (IOException e) {
            /* Error al escribir */
            System.out.println(e.getMessage());
        } catch (Exception e) {
            /* Error general */
            System.out.println("Error en el tratamiento de los ficheros");
        }

    }

    public static String aleatorioBusca(int numRegistro) {
        // Abrir, buscar datos, devolver cadena
        String cad = "";
        
        try (RandomAccessFile miRAFile = new RandomAccessFile(FICHERO, "r")) {

            // Nos vamos al registro que desea el usuario
            int posicion = (numRegistro - 1) * SIZE;
            miRAFile.seek(posicion);

            // Leer los bytes de la posición
            for (int i = 0; i < SIZE; ++i) {
                byte b = miRAFile.readByte();
                cad += (char) b;
            }

        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */
        } catch (IOException ioe) {
            /* Error al escribir */
        } catch (Exception e) {
            /* Error de otro tipo*/
            System.out.println(e.getMessage());
        }

        return cad;

    }

    public static void main(String args[]) {

        File fichero = new File(FICHERO);
        if (fichero.exists()) {
            fichero.delete();
        }

        aleatorioGraba("Mi primera cadena");
        aleatorioGraba("Mi segunda cadena");
        aleatorioGraba("Mi tercera cadena");
        aleatorioGraba("Mi cuarta cadena");
        aleatorioGraba("Mi quinta cadena");

        aleatorioNumRegistros();

        System.out.println("El registro 3 contiene:");
        System.out.println(aleatorioBusca(3));

    }

}
