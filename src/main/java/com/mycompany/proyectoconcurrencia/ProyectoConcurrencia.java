/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoconcurrencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class ProyectoConcurrencia {

 
 private NavigableSet<String> wordSet;

    public  ProyectoConcurrencia(String filename) {
        this.wordSet = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Cada linea contiene una palabra nada mas

                wordSet.add(line.trim()); // Esto lo recomendo el Chat porque me daba error y no sabia porque basicamente esto borra los espacios innecesarios
            }
        } catch (IOException e) {
            e.printStackTrace();//el try catch es una necesidad el chat me ayudo con esto porque si da exception (que puede dar, esto me protege)
        }
    }

    public boolean containsWord(String word) {
        boolean flag =wordSet.contains(word);// aca sucede la magia, basicamente si hay un numero o un simbolo# o @ (podemos agregar mas en el futuro) entonces se borra la palabra
        String regex = ".*\\d+.*";
         String regex2 = ".*[@#].*";
         if (word.matches(regex) || word.matches(regex2)){
         return true;
         }
        return flag;
    }

    public static void main(String[] args) {
        String filename = "texto.txt"; // Hay que cambiar el nombre del diccionario
        ProyectoConcurrencia searcher = new ProyectoConcurrencia(filename);

        // Miramos si ya esta en el set la palabra
        String wordToSearch = "for#@"; // Aca basicamente seran las letras que estamos buscando, en la practica deben de ser todas las palabras
        boolean found = searcher.containsWord(wordToSearch);
        //DOCUMENTO ORIGINAL
        //ELIMINAR LAS PALABRAS QUE NO QUEREMMOS
        //SI UNA PALABRA ESTA EN EL DICCIONARIO, NO LA QUEREMOS EN NUESTRO DOCUMENTO PREPROCESADO
        //ENTONCES CREAMOS UN NUEVO DOCUMENTO QUE ES EL DOC PREPROCESADO
        // EN ESTE DOC PREPROCESADO AGREGAMOS TODAS LAS PALABRAS QUE NO ESTAN EN EL DICCIONARIO
        if (found) {
            System.out.println("The word '" + wordToSearch + "' is in the set."); // esto hay que borrarlo porque no queremos imprimir en consola solo es para ver si funciona
        } else {
            System.out.println("The word '" + wordToSearch + "' is not in the set.");
        }
    }


}
