
package com.kilo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFBDriver {

    private static final Logger LOG = Logger.getLogger(SpringFBDriver.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/applicationContext.xml");
        LOG.info("Inited");
        doSomething();
    }

    private static void doSomething() {
        SpecialObject specialObject = applicationContext
                .getBean(SpecialObject.class);
        specialObject.doSomething();
    }

}
