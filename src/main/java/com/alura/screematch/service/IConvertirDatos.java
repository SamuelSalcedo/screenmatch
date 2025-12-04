package com.alura.screematch.service;

public interface IConvertirDatos {

    //clase generica
    <T> T obtenerClase(String json, Class<T> close );


}
