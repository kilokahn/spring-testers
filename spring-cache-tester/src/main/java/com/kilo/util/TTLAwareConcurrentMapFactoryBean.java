package com.kilo.util;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.FactoryBean;

import com.google.common.cache.CacheBuilder;

public class TTLAwareConcurrentMapFactoryBean implements FactoryBean<ConcurrentMap<Object, Object>> {

    private long duration;

    private TimeUnit unit;

    @Override
    public ConcurrentMap<Object, Object> getObject() throws Exception {
        return CacheBuilder.newBuilder().expireAfterWrite(duration, unit).build().asMap();
    }

    @Override
    public Class<?> getObjectType() {
        return ConcurrentMap.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }


}
