
package com.kilo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kilo.service.ReferenceDataService;

public class SpringTxAnnotationDriver {

    private static final Logger LOG = Logger
            .getLogger(SpringTxAnnotationDriver.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        LOG.info("Starting context load");
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/applicationContext.xml");
        LOG.info("Inited");
        makeServiceCalls();
        System.exit(0);
    }

    private static void makeServiceCalls() {
        ReferenceDataService referenceDataService = applicationContext
                .getBean(ReferenceDataService.class);
        try {
            referenceDataService.putReferenceData();
        } catch (RuntimeException exception) {
            LOG.error("Unhandled error", exception);
        }
        try {
            referenceDataService.getReferenceData2();
        } catch (RuntimeException exception) {
            LOG.error("Unhandled error", exception);
        }
    }

}
