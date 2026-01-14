package com.alura.screematch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class episodio {
    private Integer temporada;
    private String titulo;
    private Double numeroEpisodio;
    private Double evaluacion;
    private LocalDate fechaLanzamiento;

    public episodio(Integer numero, datosEpisodio d) {
        this.temporada = numero;
        this.titulo = d.titulo();
        try{
            this.numeroEpisodio = Double.valueOf(d.evaluacion());
        }catch (NumberFormatException e){
            this.evaluacion =0.0;
        }

        try{
            this.fechaLanzamiento = LocalDate.parse(d.fechaLanzamiento());
        }catch (DateTimeParseException e){
            this.fechaLanzamiento = null;
        }
        this.evaluacion = evaluacion;
    }

    @Override
    public String toString() {
        return "{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }

    public Double getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Double numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }
}
