
package com.kilo.proxyproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecialServiceImpl implements SpecialService {

    private static final Logger LOG = LoggerFactory
            .getLogger(SpecialServiceImpl.class);

    @Override
    @StellarMethod
    @AstralMethod
    public void doSomethingSpecial() {
        LOG.info("Did something really special");
    }

}
