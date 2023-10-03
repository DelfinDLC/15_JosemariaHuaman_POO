package S05_11JosemariaHuaman;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josem
 */
public class Recursion {
     public static void main(String[] args) {
        int numero = 5;
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));
    }

    public static int factorial(int n) {
        // Caso base
        if (n == 0) {
            return 1;
        }
        // Caso recursivo
        else {
            return n * factorial(n - 1);
        }
    }
}




