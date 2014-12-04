
package com.kilo.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS)
public class SomeObject<T> {

    private T name;

    public SomeObject() {
    }

    public SomeObject(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SomeObject [name=" + name + "]";
    }

    public String getBar() {
        return "baar";
    }
}
