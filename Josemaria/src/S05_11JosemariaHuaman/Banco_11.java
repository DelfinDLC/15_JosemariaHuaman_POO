/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S05_11JosemariaHuaman;

import java.util.Scanner;

/**
 *
 * @author josem
 */
public class Banco_11 {
    
    public static void mai(String[] args){
    
        Scanner t = new Scanner(System.in);
        
        String nombre;
        int edad;
        char sexo;
        double sueldo;
        
        System.out.println("Captura tu nombre");
        nombre = t.nextLine();
       System.out.println("Captura tu edad");
        edad = t.nextInt();
        System.out.println("Captura tu sexo");
        sexo = t.next() .charAt(0);
        System.out.println("Captura tu sueldo");
        sueldo = t.nextDouble();
        
        System.out.println("Tus datos son:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
        System.out.println("Sueldo: " + sueldo);
        
    }
    
}
