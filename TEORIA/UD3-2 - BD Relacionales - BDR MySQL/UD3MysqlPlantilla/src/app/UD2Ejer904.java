package app;

import menu.Menu;
import menu.Opciones;

public class UD2Ejer904 {

    public static void main(String[] args) {

        Opciones.ConectarMySQL("biblioteca", "root", "1234");

        Menu.Mostrar();
        
        Opciones.Desconectar();
        
    }
}
