
package com.kilo.driver;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

public class SpringCacheTesterDriver {

    private static Logger LOG = Logger.getLogger(SpringCacheTesterDriver.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/spring/applicationContext.xml",
                "classpath:com/kilo/spring/logging.xml");
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
