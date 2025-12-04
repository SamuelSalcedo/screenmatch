package com.alura.screematch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.screematch.service.*;

import java.util.Scanner;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreematchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        System.out.println("HOLA WE");
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa el nombre de la serie que buscas: \n");
        //var busqueda = leer.nextLine();

        //String direccion = "https://www.omdbapi.com/?t="+busqueda+"&apikey=d31d9f71";


        var consumible = new consumoAPI();

        String direccion = consumoAPI.getApiUrl();

        var json = consumible.obtenerDatos(direccion);
        System.out.println(json);
    }
}
