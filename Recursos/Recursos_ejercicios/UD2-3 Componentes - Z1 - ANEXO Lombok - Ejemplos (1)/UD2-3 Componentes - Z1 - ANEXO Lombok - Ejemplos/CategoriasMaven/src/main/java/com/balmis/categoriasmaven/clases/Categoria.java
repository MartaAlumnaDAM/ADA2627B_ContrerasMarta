
package com.balmis.categoriasmaven.clases;

import java.io.Serializable;


public class Categoria implements Serializable {
    String codigo;
    String descripcion;

    // CONSTRUCTORES
    public Categoria() {
    }

    public Categoria(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Categoria{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }
    
    
}

