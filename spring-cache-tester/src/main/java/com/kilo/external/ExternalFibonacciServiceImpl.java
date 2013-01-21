
package com.kilo.external;

import org.apache.log4j.Logger;

import com.kilo.driver.FibonacciService;

public class ExternalFibonacciServiceImpl implements FibonacciService {

    private static Logger LOG = Logger
            .getLogger(ExternalFibonacciServiceImpl.class);

    @Override
    public long getFibonacci(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }

        long fiboMinusOne = getFibonacci(index - 1);
        long fiboMinusTwo = getFibonacci(index - 2);

        return fiboMinusOne + fiboMinusTwo;
    }

    /**
     * Constantly returns -1
     * 
     * @param index
     * @return
     */
    public long getNonFibonacci(int index) {
        return -1;
    }

    @Override
    public void flushFibonacciCache() {
        // No-op
        LOG.info("No-op");
    }

}
