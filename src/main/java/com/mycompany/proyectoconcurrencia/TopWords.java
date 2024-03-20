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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TopWords {

    private String inputFilename;
    private String outputFilename;

    public TopWords(String inputFilename, String outputFilename) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
    }

    /*public void filterLines() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {
            String line;
            int[] Array_Repeticiones_Maximas = new int[20];// este array solo me dice el numero maximo de repeticiones
            String[] Objects = new String[20];
            int posicion_minimo = 0;//posicion_minimo es la posicion del valor minimo del array
            int minimum = Array_Repeticiones_Maximas[0]; //minimum es el valor minimo del array

            // Create a new array object with 5 elements
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String word = parts[0];
                    int number = Integer.parseInt(parts[1]);
                    if (number >= 2000) {
                        bw.write(line);
                        bw.newLine();  
                            // este codigo lo hice todo yo, basicamente aca si el numero de la linea actual que estamos evaluando es MAYOR al valor minimo en nuestro array
                            //entonces cambiamos ese valor minimo en el array de repeticiones y cambiamos el numero menor.
                        if (number > minimum) {
                          
                            Array_Repeticiones_Maximas[posicion_minimo] = number;
                            Objects[posicion_minimo] = line;
                           
                            minimum = Array_Repeticiones_Maximas[0];
                            for (int i = 0; i < Array_Repeticiones_Maximas.length; i++) {
                                if (Array_Repeticiones_Maximas[i] < minimum) {
                                    posicion_minimo = i;
                                    minimum = Array_Repeticiones_Maximas[i];
                                }
                            }
                        }
                    }
                }
            }// fin del while
            
            String top_words = "--------TOP 20 PALABRAS-------\n";
            for (int i = 0; i < 20; i++) {
                top_words += Objects[i];
                top_words += "\n";
            }
            System.out.print(top_words);
            bw.write(top_words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/ // fin del metodo
    public void filterLines() {
    try (BufferedReader br = new BufferedReader(new FileReader(inputFilename)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {
        String line;
        int[] Array_Repeticiones_Maximas = new int[20];
        String[] Objects = new String[20];
        int posicion_minimo = 0;
        int minimum = Integer.MIN_VALUE; // Initialize to the smallest possible integer

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 2) {
                String word = parts[0];
                int number = Integer.parseInt(parts[1]);
                if (number >= 20) {
                    bw.write(line);
                    bw.newLine(); // Write the line to the output file
                    if (number > minimum) {
                        Array_Repeticiones_Maximas[posicion_minimo] = number;
                        Objects[posicion_minimo] = line;
                        minimum = number;
                        // Update minimum and its index
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
        String inputFilename = "part-r-00000(2)"; // Update with your input file path
        String outputFilename = "output_text_file2.txt"; // Update with your output file path
        TopWords filter = new TopWords(inputFilename, outputFilename);
        filter.filterLines();
    }
}
