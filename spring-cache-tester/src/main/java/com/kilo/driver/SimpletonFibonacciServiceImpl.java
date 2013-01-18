
package com.kilo.driver;

import org.apache.log4j.Logger;

public class SimpletonFibonacciServiceImpl implements FibonacciService {

    private static Logger LOG = Logger
            .getLogger(SimpletonFibonacciServiceImpl.class);

    @Override
    public long getFibonacci(int index) {

        if (index == 0 || index == 1) {
            return 1;
        }

        long fiboMinusOne = getFibonacci(index - 1);
        long fiboMinusTwo = getFibonacci(index - 2);

        return fiboMinusOne + fiboMinusTwo;
    }

    @Override
    public void flushFibonacciCache() {
        // No-op
        LOG.info("No-op");
    }

}
