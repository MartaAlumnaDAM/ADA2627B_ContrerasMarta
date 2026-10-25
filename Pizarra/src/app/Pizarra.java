package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
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
           
        
    }

}
