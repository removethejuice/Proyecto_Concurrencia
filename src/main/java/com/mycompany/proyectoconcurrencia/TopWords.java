package com.mycompany.proyectoconcurrencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pablo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TopWords {

    private String inputFilename;
    private String outputFilename;

    public TopWords(String inputFilename, String outputFilename) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
    }


    public void filterLines(int numero_integers) {
        int minimum_support=0;
        if(numero_integers ==1){
        minimum_support =5000;
        }
        else{
        minimum_support =1000;
        }
    try (BufferedReader br = new BufferedReader(new FileReader(inputFilename)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {
        String line;
        int[] Array_Repeticiones_Maximas = new int[20];
        String[] Objects = new String[20];
        int posicion_minimo = 0;
        int minimum = Integer.MIN_VALUE; // El mas small posible

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 2) {
                String word = parts[0];
                int number = Integer.parseInt(parts[1]);
                if (number >= 20) {
                    bw.write(line);
                    bw.newLine(); // Escribirlo al output
                    if (number > minimum) {
                        Array_Repeticiones_Maximas[posicion_minimo] = number;
                        Objects[posicion_minimo] = line;
                        minimum = number;
                        // Update minimum and its index, este tenia un error horrible pero ya funciona
                        for (int i = 0; i < Array_Repeticiones_Maximas.length; i++) {
                            if (Array_Repeticiones_Maximas[i] < minimum) {
                                posicion_minimo = i;
                                minimum = Array_Repeticiones_Maximas[i];
                            }
                        }
                    }
                }
            }
        }
        String top_words = "--------TOP 20 PALABRAS-------\n";
        for (int i = 0; i < 20; i++) {
            if (Objects[i] != null) {
                top_words += Objects[i];
                top_words += "\n";
            }
        }
        System.out.print(top_words);
        bw.write(top_words);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
        if (args.length !=2){
        System.out.println("Error ponga la cantidad apropiada de elementos");
        return;
        }
        
        int numero_integers = Integer.parseInt(args[1]);
        
        if (numero_integers !=1 && numero_integers!=2){
        System.out.println("Solo se puede 1 o 2");
        return;
        }
         String inputFilename = args[0];// Update with your input file path baby!
        String outputFilename = "output_text_file2.txt"; // Update with your output file path
        TopWords filter = new TopWords(inputFilename, outputFilename);
        filter.filterLines(numero_integers);
    }
}
