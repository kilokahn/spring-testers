
package com.kilo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SpecialObject {

    private String name;

    private Integer id;

    private Date date;

    public SpecialObject() {
    }

    public SpecialObject(String name, Integer id, Date date) {
        this.name = name;
        this.id = id;
        this.date = date;
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

    @JsonIgnore
    public String getFoo() {
        return "foo";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SpecialObject [name=" + name + ", id=" + id + ", date=" + date
                + "]";
    }

}
