package com.mycompany.buscardatosmercado;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderExample {
    public static List<String[]> readCSV(String fileUrl) {
        List<String[]> data = new ArrayList<>();
        try {
            URL url = new URL(fileUrl);
            CSVReader reader = new CSVReader(new InputStreamReader(url.openStream()));
            data = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return data;
    }

    // Método para buscar por nombre o parte del nombre
    public static List<String[]> buscarPorNombre(List<String[]> data, String nombre) {
        List<String[]> resultados = new ArrayList<>();
        for (String[] fila : data) {
            if (fila[0].toLowerCase().contains(nombre.toLowerCase())) { // Buscar por nombres en la primera columna
                resultados.add(fila);
            }
        }
        return resultados;
    }

    // Método para buscar por DNI
    public static List<String[]> buscarPorDNI(List<String[]> data, String dni) {
        List<String[]> resultados = new ArrayList<>();
        for (String[] fila : data) {
            if (fila[3].equals(dni)) { // Buscar por DNI en la cuarta columna
                resultados.add(fila);
            }
        }
        return resultados;
    }
}
