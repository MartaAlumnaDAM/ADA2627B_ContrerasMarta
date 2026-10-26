package app;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {

    private int id;
    private String nombre;
    private String ciudad;
    private ArrayList<Double> notas;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String ciudad, ArrayList<Double> notas) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "', ciudad='" + ciudad + "', notas=" + notas + "}";}

}
