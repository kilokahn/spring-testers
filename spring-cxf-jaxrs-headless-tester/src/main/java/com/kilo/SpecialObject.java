
package com.kilo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class SpecialObject {

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

    private String name;

    private Integer id;

    private Date date;

    public SpecialObject() {
    }

    public SpecialObject(String name, Integer id, Date date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public SpecialObject(String json) throws JsonParseException,
            JsonMappingException, IOException {
        SpecialObject that = objectMapper.readValue(json, SpecialObject.class);
        this.name = that.name;
        this.id = that.id;
        this.date = that.date;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @JsonIgnore
    public String getFoo() {
        return "foo";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Unable to write JSON output",
                    exception);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
