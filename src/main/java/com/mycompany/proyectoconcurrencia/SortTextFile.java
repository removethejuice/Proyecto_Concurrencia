/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoconcurrencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pablo
 */
public class SortTextFile {
     private String filename;

    public SortTextFile (String filename) {
        this.filename = filename;
    }

    public void sortAndWriteToFile() {
        List<String> elements = readElementsFromFile();
        Collections.sort(elements); // Aca se hace sort de manera alfabetica, suerte que JAVA tiene esto
        writeElementsToFile(elements);
    }

    private List<String> readElementsFromFile() {
        List<String> elements = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (elements.contains(line)== false){ //basicamente no agrego elementos si ya estan en la lista
                elements.add(line);} // Agrego cada linea como un elemento
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }

    private void writeElementsToFile(List<String> elements) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String element : elements) {
                bw.write(element);
                bw.newLine(); // Aca agrego un salto de linea porque    Word    Counter usa el salto de linea como delimitador
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "texto.txt"; // Texto.txt es mi diccionario pero creo que ese nombre esta medio estupido hay que cambiarlo pero no se me ocurre que poner ahoita
        SortTextFile sorter = new SortTextFile(filename);
        sorter.sortAndWriteToFile();
    }
}
