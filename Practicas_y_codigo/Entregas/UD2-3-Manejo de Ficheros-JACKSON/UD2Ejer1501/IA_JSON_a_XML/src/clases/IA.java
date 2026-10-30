package clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonRootName("ia")
@JsonPropertyOrder({ "nombre", "url", "model" })
public class IA implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @JacksonXmlProperty(localName = "nombre")
    String nombre;
    
    @JacksonXmlProperty(localName = "url")
    String url;

    @JacksonXmlProperty(localName = "model")
    String model;
    
    @JacksonXmlProperty(localName = "propietario")
    Propietario propietario;

    // Constructores

    public IA() {
    }

    public IA(String nombre, String url, String model, Propietario propietario) {
        this.nombre = nombre;
        this.url = url;
        this.model = model;
        this.propietario = propietario;
    }
    
    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    // toString

    @Override
    public String toString() {
        return "IA{" + "nombre=" + nombre + ", url=" + url + ", model=" + model + ", propietario=" + propietario + '}';
    }
    
    
    
}
