package app;
import com.google.gson.Gson;
/**
 *
 * @author marta
 */
public class Programa {
    private int codigo;
    private String nombre;
    private String carpeta;

    public Programa(int codigo, String nombre, String carpeta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carpeta = carpeta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    @Override
    public String toString() {
        return "Programa{" + "codigo=" + codigo + ", nombre=" + nombre + ", carpeta=" + carpeta +'}';
    }
    
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
