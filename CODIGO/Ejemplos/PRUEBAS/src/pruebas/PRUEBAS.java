/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author marta
 */
public class PRUEBAS {

    /**
     * @param args the command line arguments
     */
    
    static boolean es_primo(int num){
        
            boolean primo;
            int i;
            
            primo = true;
            i = 2;
            
            while(i<num && primo){
            
                if(num%i==0){
                    primo = false;
                }
                i++;
            }
            
            return primo;
            
        }
    public static void main(String[] args) {
        
        System.out.println("Inserta un número: ");
        Scanner teclado = new Scanner(System.in);
        int num = Integer.parseInt(teclado.nextLine()) ;
        boolean resultado = es_primo(num);
        
        String esPrimo = resultado ? "es primo" : "no es primo";
        
        System.out.println("El número " + num + esPrimo);
    }}
    

