package com.kilo;

import org.apache.log4j.Logger;

public class SpecialObject {

    private static final Logger LOG = Logger.getLogger(SpecialObject.class);

    public void doSomething() {
        LOG.info("Did something special");
    }

}
