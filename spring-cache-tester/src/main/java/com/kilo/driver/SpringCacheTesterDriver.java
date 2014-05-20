
package com.kilo.driver;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import com.kilo.external.ExternalFibonacciServiceImpl;

public class SpringCacheTesterDriver {

    private static Logger LOG = Logger.getLogger(SpringCacheTesterDriver.class);

    public static void main(String[] args) {

        try (ConfigurableApplicationContext applicationContext = new GenericXmlApplicationContext(
                "classpath:com/kilo/spring/applicationContext.xml",
                "classpath:com/kilo/spring/logging.xml")) {
            FibonacciService simpletonFibonacciService = (FibonacciService) applicationContext
                    .getBean("simpletonFibonacciService");
            FibonacciService concurrentMapFibonacciService = (FibonacciService) applicationContext
                    .getBean("concurrentMapFibonacciService");
            FibonacciService ehcacheFibonacciService = (FibonacciService) applicationContext
                    .getBean("ehcacheFibonacciService");
            FibonacciService externalFibonacciService = (FibonacciService) applicationContext
                    .getBean("externalFibonacciService");

            doWorkWithFiboService(simpletonFibonacciService);
            doWorkWithFiboService(concurrentMapFibonacciService);
            doWorkWithFiboService(ehcacheFibonacciService);
            doWorkWithFiboService(externalFibonacciService);

            long fibonacci = ((ExternalFibonacciServiceImpl) externalFibonacciService)
                    .getFibonacci(45);
            LOG.info("Fibonacci number is " + fibonacci);
            long nonFibonacci = ((ExternalFibonacciServiceImpl) externalFibonacciService)
                    .getNonFibonacci(45);
            LOG.info("Non-fibonacci number is " + nonFibonacci);
        }
        System.exit(1);
    }

    private static void doWorkWithFiboService(FibonacciService fibonacciService) {
        // First one
        doHeavyLifting(fibonacciService);
        // Some more
        doHeavyLifting(fibonacciService);
        // Come on... one last
        doHeavyLifting(fibonacciService);
        // Now flush
        fibonacciService.flushFibonacciCache();
        // Do some more
        doHeavyLifting(fibonacciService);
        // Be polite - clean out at the end - flush!
        fibonacciService.flushFibonacciCache();
    }

    private static void doHeavyLifting(FibonacciService fibonacciService) {
        StopWatch sw = new StopWatch();
        sw.start();
        fibonacciService.getFibonacci(45);
        sw.stop();

        LOG.info(fibonacciService.getClass().getCanonicalName() + " took "
                + sw.getTotalTimeSeconds() + " seconds");
    }

}
