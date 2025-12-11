package com.alura.screematch.Main;

import com.alura.screematch.model.datoSerie;
import com.alura.screematch.model.datosTemporadas;
import com.alura.screematch.service.ConvierteDatos;
import com.alura.screematch.service.consumoAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private Scanner entrada = new Scanner(System.in);

    private consumoAPI consumoApi= new consumoAPI();

    private ConvierteDatos convertidor = new ConvierteDatos();


    //private final URL_BASE = "";
    public void mostrarMenu(){

        System.out.println("Escribe el nombre de la serie que buscas: ");
        var nombreSerie = entrada.nextLine();

        var json = consumoApi.obtenerDatos(consumoApi.getApiUrl(nombreSerie));
        System.out.println(json);

        //convertir los datos crudos de la api a los que se requieren con las clases
        var datos = convertidor.obtenerClase(json, datoSerie.class);
        System.out.println(datos);

        List<datosTemporadas> temporadas = new ArrayList<>();

        //AHORA consulta el metodo para hacer
        for (int i =1; i <= datos.totalTemporadas(); i++) {
            var json2 = consumoApi.obtenerDatos(consumoApi.getApiTemporadas(nombreSerie, i));
            var temporadaActual = convertidor.obtenerClase(json2, datosTemporadas.class);
            temporadas.add(temporadaActual);
        }

       // temporadas.forEach(System.out::println);

        //funcion lambda para simplificar los episodios
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())) );
    }

}

