
package com.kilo;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SpecialObject {

    private static ObjectMapper objectMapper = new ObjectMapper();

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

    public String getFoo() {
        return "foo";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SpecialObject [name=" + name + ", id=" + id + ", date=" + date
                + "]";
    }

}
