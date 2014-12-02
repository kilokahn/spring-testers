
package com.kilo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

public class RawTypeDrivenParamConverterProvider implements
        ParamConverterProvider {

    private Map<Class<?>, ParamConverter<?>> converterMap;

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType,
            Type genericType, Annotation[] annotations) {
        return (ParamConverter<T>) converterMap.get(rawType);
    }

    public void setConverterMap(Map<Class<?>, ParamConverter<?>> converterMap) {
        this.converterMap = converterMap;
    }
}
