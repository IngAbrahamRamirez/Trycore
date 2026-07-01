package com.pruebatecnica.api.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private JsonUtils() {
    }

    public static String toJson(Object object) {

        try {

            return mapper.writeValueAsString(object);

        } catch (JsonProcessingException e) {

            e.printStackTrace();

            throw new RuntimeException(e);

        }

    }

}