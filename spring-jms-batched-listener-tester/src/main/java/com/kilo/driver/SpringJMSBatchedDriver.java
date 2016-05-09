
package com.kilo.driver;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringJMSBatchedDriver {

    private static Logger LOG = LoggerFactory
            .getLogger(SpringJMSBatchedDriver.class);

    public static void main(String[] args) throws InterruptedException {

        try (ConfigurableApplicationContext applicationContext =
                new GenericXmlApplicationContext(
                        "classpath:com/kilo/spring/applicationContext.xml",
                        "classpath:com/kilo/spring/logging.xml")) {
            LOG.info("Inited");
            JmsTemplate template =
                    applicationContext.getBean("testJmsTemplate",
                            JmsTemplate.class);
            ScheduledExecutorService scheduledThreadExecutor =
                    Executors.newScheduledThreadPool(1);
            scheduledThreadExecutor.scheduleWithFixedDelay(
                    new TestMessagePublisher(template), 10, 30,
                    TimeUnit.SECONDS);

            // Sleep for an hour while we play around
            Thread.sleep(60 * 60 * 1_000);
            scheduledThreadExecutor.shutdownNow();
        }
    }

}

class TestMessagePublisher implements Runnable {

    private static final Logger LOG = LoggerFactory
            .getLogger(TestMessagePublisher.class);

    private final JmsTemplate template;

    public TestMessagePublisher(JmsTemplate template) {
        this.template = template;
    }

    public void run() {
        Date date = new Date();
        LOG.info("Running publisher at: {}", date);
        LongStream.rangeClosed(1, 10).map(i -> date.getTime() + i)
                .forEach(template::convertAndSend);
    }
}
