
package clases;

import com.fasterxml.jackson.annotation.JsonRootName;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonRootName("portales")
public class Portales implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ia")
    ArrayList<IA> portales;

    // Constructores
    
    public Portales() {
    }

    public Portales(ArrayList<IA> portales) {
        this.portales = portales;
    }
    
        
    // Getters y Setters
    

    public ArrayList<IA> getPortales() {
        return portales;
    }

    public void setPortales(ArrayList<IA> portales) {
        this.portales = portales;
    }

    
    
    // toString

    @Override
    public String toString() {
        return "Portales{" + "portales=" + portales + '}';
    }

    

    
}
