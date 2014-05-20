
package com.kilo;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CXFHeadlessDriver {

    private static Logger LOG = Logger.getLogger(CXFHeadlessDriver.class);

    public static void main(String[] args) throws InterruptedException {
        try (ConfigurableApplicationContext applicationContext = new GenericXmlApplicationContext(
                "classpath:com/kilo/cxf/logging.xml",
                "classpath:com/kilo/cxf/applicationContext.xml")) {
            LOG.info("Inited");
            // Sleep for an hour while we play around
            Thread.sleep(60* 60 * 1_000);
        }
    }
}
