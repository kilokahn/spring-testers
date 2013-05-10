
package com.kilo;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmbeddedJettyDriver {

    private static Logger LOG = Logger.getLogger(EmbeddedJettyDriver.class);

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext(
                "classpath:com/kilo/embedded/jetty/logging.xml",
                "classpath:com/kilo/embedded/jetty/applicationContext.xml");
        LOG.info("Inited");
    }

}
