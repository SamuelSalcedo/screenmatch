package com.alura.screematch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvertirDatos{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerClase(String json, Class<T> close) {
        try {
            return objectMapper.readValue(json,close);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
