
package com.kilo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTesterDriver {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/spring/logging.xml",
                "classpath:com/kilo/spring/applicationContext.xml");
        context.registerShutdownHook();
    }
}
