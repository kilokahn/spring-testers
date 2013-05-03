
package com.kilo;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ParamConverter;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class SpecialObjectHandler implements ParamConverter<SpecialObject> {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        DeserializationConfig deserializationConfig = objectMapper
                .getDeserializationConfig();
        DeserializationConfig deserializationConfigWithDateFormat = deserializationConfig
                .withDateFormat(new SimpleDateFormat("yyyyMMddHH:mm:ss.S"));
        objectMapper
                .setDeserializationConfig(deserializationConfigWithDateFormat);

        SerializationConfig serializationConfig = objectMapper
                .getSerializationConfig();
        SerializationConfig serializationConfigWithDateFormat = serializationConfig
                .withDateFormat(new SimpleDateFormat("yyyyMMddHH:mm:ss.S"));
        objectMapper.setSerializationConfig(serializationConfigWithDateFormat);
    }

    @Override
    public SpecialObject fromString(String json) {
        try {
            return objectMapper.readValue(json, SpecialObject.class);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Unable to write JSON output",
                    exception);
        }
    }

    @Override
    public String toString(SpecialObject value) throws IllegalArgumentException {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Unable to write JSON output",
                    exception);
        }
    }

}
