/*
 * Driver.java
 * 
 * $HeadURL: $
 * $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */

/*
 * Copyright (c) 2012 D. E. Shaw & Co., L.P. All rights reserved.
 *  
 * This software is the confidential and proprietary information
 * of D. E. Shaw & Co., L.P. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with D. E. Shaw & Co., L.P.
 */

package com.kilo.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/spring/applicationContext.xml");
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

    /**
     * @param fibonacciService
     */
    private static void doHeavyLifting(FibonacciService fibonacciService) {
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < 1000; i++) {
            fibonacciService.getFibonacci(35);
        }
        sw.stop();

        System.out
                .println("This took " + sw.getTotalTimeSeconds() + " seconds");
    }

}
