
package com.kilo.common.jaxrs;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationMixinSetter implements BeanFactoryPostProcessor {

    private Map<Class<?>, Class<?>> mixinClassMap;

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ObjectMapper objectMapper = beanFactory.getBean(ObjectMapper.class);
        if (objectMapper == null) {
            throw new IllegalStateException("No object mapper found");
        }
        if (mixinClassMap != null) {
            objectMapper.setMixInAnnotations(mixinClassMap);
        }

    }

    public void setMixinClassMap(
            Map<Class<?>, Class<?>> serializationMixinClassMap) {
        this.mixinClassMap = serializationMixinClassMap;
    }

}
