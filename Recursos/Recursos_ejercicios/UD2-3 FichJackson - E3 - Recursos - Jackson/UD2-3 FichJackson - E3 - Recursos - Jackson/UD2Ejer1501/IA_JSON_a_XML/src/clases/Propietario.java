package clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonRootName("propietario")
@JsonPropertyOrder({ "nombre", "fundacion", "sede" })
public class Propietario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @JacksonXmlProperty(localName = "nombre", isAttribute = true)
    String nombre;
    
    @JacksonXmlProperty(localName = "fundacion")
    int fundacion;
    
    @JacksonXmlProperty(localName = "sede")
    String sede;
    
    // Constructores
    
    public Propietario() {
    }
    
    public Propietario(String nombre, int fundacion, String sede) {
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.sede = sede;
    }
    
    
    // Getters y Setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    
    // toString

    @Override
    public String toString() {
        return "Propietario{" + "nombre=" + nombre + ", fundacion=" + fundacion + ", sede=" + sede + '}';
    }
    
    


    
}
