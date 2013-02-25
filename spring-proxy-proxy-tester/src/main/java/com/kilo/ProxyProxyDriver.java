
package com.kilo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kilo.proxyproxy.SpecialService;

public class ProxyProxyDriver {

    private static Logger LOG = LoggerFactory.getLogger(ProxyProxyDriver.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/proxyproxy/logging.xml",
                "classpath:com/kilo/proxyproxy/applicationContext.xml");
        LOG.info("Inited");
        makeServiceCalls();
    }

    private static void makeServiceCalls() {
        SpecialService specialService = applicationContext
                .getBean(SpecialService.class);
        specialService.doSomethingSpecial();
    }

}
