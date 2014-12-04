
package com.kilo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SomeOtherObject extends SomeObject<String> {

    private String code;
    
    private Integer id;

    public SomeOtherObject() {
    }

    public SomeOtherObject(String name) {
        super(name);
        this.id = name.hashCode();
    }

    public SomeOtherObject(String name, String code) {
        super(name);
        this.code = code;
        this.id = code.hashCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SomeOtherObject [code=" + code + ", name=" + getName() + "]";
    }

    @JsonIgnore
    public String getFoo() {
        return "fooo";
    }
}
