
package com.kilo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

public class ApplicationParamConverterProvider implements
        ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType,
            Type genericType, Annotation[] annotations) {
        if (rawType == Date.class) {
            return (ParamConverter<T>) new ProgressiveDateConverter();
        } else if (rawType == SpecialObject.class) {
            return (ParamConverter<T>) new SpecialObjectHandler();
        }
        return null;
    }

}
