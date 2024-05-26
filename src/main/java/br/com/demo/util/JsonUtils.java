package br.com.demo.util;

import br.com.demo.exception.JsonUtilsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public record JsonUtils() {

    private static final JsonMapper JSON_MAPPER = createJsonMapper();

    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return JSON_MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new JsonUtilsException(e);
        }
    }

    public static String toJson(Object obj) {
        try {
            return JSON_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonUtilsException(e);
        }
    }

    private static JsonMapper createJsonMapper() {
        JsonMapper jsonMapper = JsonMapper.builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .build();

        jsonMapper.registerModule(new JavaTimeModule());
        return jsonMapper;
    }
}
