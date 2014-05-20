package com.kilo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Service1 {

    private static Logger LOG = LoggerFactory.getLogger(Service1.class);

    private DAO1 dao1;

    public void foo(String str) {
        LOG.info("Am in Service1 for input {}", str);
        dao1.foo(str);
    }

    public void setDao1(DAO1 dao1) {
        this.dao1 = dao1;
    }
}
