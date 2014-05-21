
package com.kilo.driver;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class SpringTestContextDriver {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext applicationContext = new GenericXmlApplicationContext(
                "classpath:com/kilo/spring/applicationContext.xml")) {
            System.out.println("Inited");
            FibonacciService fibonacciService = applicationContext
                    .getBean(FibonacciService.class);

            // First one
            doHeavyLifting(fibonacciService);
            // Some more
            doHeavyLifting(fibonacciService);
            // Some more
            doHeavyLifting(fibonacciService);
            // Some more
            doHeavyLifting(fibonacciService);
            // Come on... one last
            doHeavyLifting(fibonacciService);
            // Now flush
            fibonacciService.flushFibonacciCache();
            // Do some more
            doHeavyLifting(fibonacciService);
        }
    }

    /**
     * @param fibonacciService
     */
    private static void doHeavyLifting(FibonacciService fibonacciService) {
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < 1000; i++) {
            fibonacciService.getFibonacci(25);
        }
        sw.stop();

        System.out
                .println("This took " + sw.getTotalTimeSeconds() + " seconds");
    }

}
