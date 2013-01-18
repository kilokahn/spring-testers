package com.kilo;

import org.springframework.beans.factory.FactoryBean;

public class SpecialFactoryBean implements FactoryBean<SpecialObject> {

    private static SpecialObject ourInstance = new SpecialObject();

    @Override
    public SpecialObject getObject() throws Exception {
        return ourInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return SpecialObject.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
