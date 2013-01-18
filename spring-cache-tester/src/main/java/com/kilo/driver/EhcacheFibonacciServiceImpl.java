
package com.kilo.driver;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class EhcacheFibonacciServiceImpl implements FibonacciService {

    private static Logger LOG = Logger
            .getLogger(EhcacheFibonacciServiceImpl.class);

    @Override
    @Cacheable("fibonacciEhcache")
    public long getFibonacci(int index) {

        if (index == 0 || index == 1) {
            return 1;
        }

        long fiboMinusOne = getFibonacci(index - 1);
        long fiboMinusTwo = getFibonacci(index - 2);

        return fiboMinusOne + fiboMinusTwo;
    }

    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true, value = "fibonacciEhcache")
    public void flushFibonacciCache() {
        LOG.info("Royal Ehcache flush");
    }

}
