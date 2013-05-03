
package com.kilo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
public abstract class SpecialObjectMixin extends SpecialObject {

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

    @JsonProperty
    @Override
    public String getName() {
        return super.getName();
    }

    @JsonProperty
    @Override
    public Date getDate() {
        return super.getDate();
    }

    @JsonCreator
    public SpecialObjectMixin(String json) throws JsonParseException,
            JsonMappingException, IOException {
        SpecialObject that = objectMapper.readValue(json, SpecialObject.class);
        super.setName(that.getName());
        super.setId(that.getId());
        super.setDate(that.getDate());
    }

    @Override
    public String toString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Unable to write JSON output",
                    exception);
        }
    }

}
