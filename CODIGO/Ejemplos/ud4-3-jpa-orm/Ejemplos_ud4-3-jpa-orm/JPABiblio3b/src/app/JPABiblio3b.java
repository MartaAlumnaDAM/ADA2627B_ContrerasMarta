package app;

import java.io.IOException;
import menu.Menu;

public class JPABiblio3b {

    public static void main(String[] args) {
        try {
            Menu.mostrar();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
