
package com.kilo;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PPCDriver {
    private static Logger LOG = Logger.getLogger(PPCDriver.class);

    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = new GenericXmlApplicationContext(
                "classpath:com/kilo/ppc/logging.xml",
                "classpath:com/kilo/ppc/applicationContext.xml")) {
            LOG.info("Inited");
            SimpleBean simpleBean = applicationContext
                    .getBean(SimpleBean.class);
            simpleBean.doSimpleThings();
        }
    }

}
