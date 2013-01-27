
package com.kilo;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class MyComplexObject {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private String name;

    private Integer id;

    private Date date;

    public MyComplexObject() {
    }

    public MyComplexObject(String name, Integer id, Date date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public MyComplexObject(String json) throws JsonParseException,
            JsonMappingException, IOException {
        MyComplexObject that = objectMapper.readValue(json,
                MyComplexObject.class);
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
}
