package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

interface Filtrar<T>{
    boolean filtra(T n);
}

public class Pizarra {

    public static ArrayList<Integer> filtra(
            ArrayList<Integer> entrada,
            Filtrar<Integer> filtra) {

        return  new ArrayList<>(entrada.stream()
                .filter(filtra::filtra)
                .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        
        Integer[] l = {1,2,3,4,5,6,7,8};
        
        ArrayList<Integer> lista = new ArrayList<Integer>(Arrays.asList(l));
        
        ArrayList<Integer> pares = filtra(lista, (n) -> n / 2 == 0 );
        
        for(Integer par : pares){
            System.out.println(par);
        }
    }

}
