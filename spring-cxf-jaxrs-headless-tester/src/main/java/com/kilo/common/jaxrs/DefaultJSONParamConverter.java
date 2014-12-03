
package com.kilo.common.jaxrs;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import javax.ws.rs.ext.ParamConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultJSONParamConverter<T> implements ParamConverter<T> {

    private ObjectMapper objectMapper;

    @Override
    public T fromString(String value) {
        try {
            return (T) objectMapper.readValue(value, getClassOfT());
        } catch (IOException exception) {
            throw new IllegalArgumentException("Unable to read JSON input",
                    exception);
        }
    }

    /**
     * In the absence of reified generics, use the next best thing:
     * 
     * <pre>
     * http://stackoverflow.com/questions/182636/how-to-determine-the-class-of-a-generic-type
     * </pre>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    private Class<T> getClassOfT() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public String toString(T value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Unable to write JSON output",
                    exception);
        }
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

}
