package com.alura.screematch.service;

import java.io.FileInputStream;
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

    public static String getApiUrl(){
        final Properties properties;
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            String urlBase = properties.getProperty("BASE_URL");
            String key = properties.getProperty("API_KEY");

            //SOLO REGRESA LA URL CON LA API LISTA PARA HACER LA PETICION
            return urlBase;

        } catch (IOException ex) {
            System.out.println("Error al cargar config.properties. Asegurate de que este bien escrita");
            return null;
        }
    }

}
