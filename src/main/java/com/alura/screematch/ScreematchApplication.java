package com.alura.screematch;

import com.alura.screematch.Main.Main;
import com.alura.screematch.model.datoSerie;
import com.alura.screematch.model.datosEpisodio;
import com.alura.screematch.model.datosTemporadas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.screematch.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreematchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        System.out.println("HOLA WE");
        Main principal = new Main();
        principal.mostrarMenu();
    }
}
