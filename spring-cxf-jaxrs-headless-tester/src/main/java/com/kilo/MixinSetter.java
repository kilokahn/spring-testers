
package com.kilo;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MixinSetter implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ObjectMapper objectMapper = beanFactory.getBean(ObjectMapper.class);

        // Add all mixin settings
        objectMapper.getSerializationConfig().addMixInAnnotations(
                SpecialObject.class, SpecialObjectMixin.class);
        objectMapper.getDeserializationConfig().addMixInAnnotations(
                SpecialObject.class, SpecialObjectMixin.class);
    }

}
