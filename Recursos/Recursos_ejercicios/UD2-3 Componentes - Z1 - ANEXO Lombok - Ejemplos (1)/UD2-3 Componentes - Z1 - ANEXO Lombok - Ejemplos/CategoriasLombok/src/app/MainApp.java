
package app;

import clases.Categoria;
import java.util.ArrayList;


public class MainApp {


    public static void main(String[] args) {
        
        ArrayList<Categoria> lista = datosCategorias();
        
        mostrarCategorias(lista);
        
    }

    public static ArrayList<Categoria> datosCategorias() {
        ArrayList<Categoria> lista = new ArrayList<>();
        Categoria cat = new Categoria();
     
        cat.setCodigo("L");
        cat.setDescripcion("Vehículos ligeros");
        lista.add(cat);

        cat = new Categoria();
        cat.setCodigo("M");
        cat.setDescripcion("Transporte de personas");
        lista.add(cat);

        cat = new Categoria();
        cat.setCodigo("N");
        cat.setDescripcion("Transporte de mercancías");
        lista.add(cat);

        cat = new Categoria();
        cat.setCodigo("O");
        cat.setDescripcion("Remolques y semirremolques");
        lista.add(cat);

        cat = new Categoria();
        cat.setCodigo("T");
        cat.setDescripcion("Vehículos agrícolas");
        lista.add(cat);
        
        return lista;
    }
    
    
    public static void mostrarCategorias(ArrayList<Categoria> lista) {
        for (Categoria c: lista) {
            System.out.println(c.toString());
        }
    }

    
}
