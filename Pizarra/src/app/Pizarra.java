package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
<<<<<<< HEAD

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
=======
import org.json.JSONArray;
import org.json.JSONObject;

public class Pizarra {

    public static void main(String[] args) {
        
        JSONObject json = new JSONObject();
        
        json.put("elementoUno:", "Primero");
        json.put("elementoDos:", "Segundo");
        
        JSONArray jArray = new JSONArray();
        JSONObject jObj;
        
        jObj = new JSONObject();
        jObj.put("subelementoUno:", "Subelemento1");
        jArray.put(jObj);
        
        jObj = new JSONObject();
        jObj.put("subelementoDos:", "Subelemento2");
        jArray.put(jObj);
        
        json.put("subelementos: ", jArray);
        
        System.out.println(json.toString(2));
           
        
>>>>>>> e7f819b2aa2c04ea1aa281bc28974e9c394e9d7a
    }

}
