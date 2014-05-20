
package com.kilo.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJMSDriver {

    private static Logger LOG = LoggerFactory.getLogger(SpringJMSDriver.class);

    public static void main(String[] args) throws InterruptedException {

        try (ConfigurableApplicationContext applicationContext = new GenericXmlApplicationContext(
                "classpath:com/kilo/spring/applicationContext.xml",
                "classpath:com/kilo/spring/logging.xml")) {
            LOG.info("Inited");
            // Sleep for an hour while we play around
            Thread.sleep(60 * 60 * 1_000);
        }
    }

}
