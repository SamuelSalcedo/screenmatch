package com.alura.screematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record datoSerie (
        //@JsonAlias("Title") String titulo,
      //  @JsonProperty("Year") String fecha,
       // @JsonAlias("Director") String director,
        //@JsonAlias("totalSeasons")Integer totalTemporadas,
        @JsonAlias("totalSeasons")Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion){
//        @JsonAlias("Actors") String actores){
}
