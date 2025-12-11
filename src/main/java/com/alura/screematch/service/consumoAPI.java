package com.alura.screematch.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class consumoAPI {

    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }


    //esta creada para obtener unicamente los datos de una serie en crudo
    public String getApiUrl(String nombreserie){
        final Properties properties;
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            final String URL_BASE = properties.getProperty("BASE_URL");
            final String API_KEY = properties.getProperty("API_KEY");

            //SOLO REGRESA LA URL CON LA API LISTA PARA HACER LA PETICION
            System.out.println("API KEY RECUPERADA CORRECTAMENTE");
            return URL_BASE+nombreserie.replace(" ","+")+API_KEY;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //esta creada para obtener los datos de una serie en y sus temporadas
    public String getApiTemporadas(String nombreserie, int numTemporada){
        final Properties properties;
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            final String URL_BASE = properties.getProperty("BASE_URL");
            final String API_KEY = properties.getProperty("API_KEY");

            //SOLO REGRESA LA URL CON LA API LISTA PARA HACER LA PETICION
           // System.out.println("API KEY RECUPERADA CORRECTAMENTE");
            return URL_BASE+nombreserie.replace(" ","+")+"&Season="+numTemporada+API_KEY;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
