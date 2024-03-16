/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoconcurrencia;

import java.util.Random;

public class testing {

    public static void main(String[] args) {
        int[] Array_Repeticiones_Maximas = new int[7];
        int posicion_minimo = 0;
        int minimum = 0;
        int[] b = new int[4];
        for (int i = 0; i < Array_Repeticiones_Maximas.length; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            Array_Repeticiones_Maximas[i] = randomNumber;
            if (randomNumber > minimum) {
                b[posicion_minimo] = randomNumber;
                minimum = Array_Repeticiones_Maximas[0];
                for (int j = 1; j < b.length; j++) {
                    if (b[j] < minimum) {
                        posicion_minimo = j;
                        minimum = b[j];
                    }// fin del if
                }// fin del for
            }
        }
        System.out.println("EL ARRAY ORIGINAL:  ");
        for (int i = 0; i <Array_Repeticiones_Maximas.length; i++) {
            
            System.out.print(Array_Repeticiones_Maximas[i] + "   ");
        }
        
        System.out.println("EL ARRAY DE MAXIMOS");
         for (int i = 0; i < b.length; i++) {
            
            System.out.print(b[i] + "   ");
        }
         posicion_minimo =0;
         for (int i = 0; i < Array_Repeticiones_Maximas.length; i++) {
          if (Array_Repeticiones_Maximas[i] > minimum) {
                b[posicion_minimo] = Array_Repeticiones_Maximas[i];
                minimum = Array_Repeticiones_Maximas[0];
                for (int j = 1; j < 4; j++) {
                    if (b[j] < minimum) {
                        posicion_minimo = j;
                        minimum = b[j];
                    }// fin del if
                }// fin del for
            }   
        }
             System.out.println("EL ARRAY DE MAXIMOS");
         for (int i = 0; i < b.length; i++) {
            
            System.out.print(b[i] + "   ");
        }
    }// fin del main
}
