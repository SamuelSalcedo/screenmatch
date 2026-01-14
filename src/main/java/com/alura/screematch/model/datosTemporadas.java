package com.alura.screematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public record datosTemporadas(
        @JsonAlias("Season") Integer numero,
        @JsonAlias("Episodes") List<datosEpisodio> episodios
        ) {
}
