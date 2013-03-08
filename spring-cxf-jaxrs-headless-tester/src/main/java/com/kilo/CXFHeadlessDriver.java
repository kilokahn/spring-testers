
package com.kilo;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CXFHeadlessDriver {

    private static Logger LOG = Logger.getLogger(CXFHeadlessDriver.class);

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext(
                "classpath:com/kilo/cxf/logging.xml",
                "classpath:com/kilo/cxf/applicationContext.xml");
        LOG.info("Inited");
    }

}
