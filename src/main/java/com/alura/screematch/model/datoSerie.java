package com.alura.screematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record datoSerie (
        @JsonAlias("Title") String titulo,
        @JsonProperty("Year") String fecha,
        @JsonAlias("Director") String director,
        @JsonAlias("Actors") String actores){
}
