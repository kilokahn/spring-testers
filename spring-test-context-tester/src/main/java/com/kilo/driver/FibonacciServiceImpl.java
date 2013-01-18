/*
 * FibonacciServiceImpl.java
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


//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
public class FibonacciServiceImpl implements FibonacciService {

    /**
     * {@inheritDoc}
     */
    @Override
    public long getFibonacci(int index) {

        // System.out.println("getFibonacci called for " + index);

        if (index == 0 || index == 1) {
            return 1;
        }

        long fiboMinusOne = getFibonacci(index - 1);
        long fiboMinusTwo = getFibonacci(index - 2);

        return fiboMinusOne + fiboMinusTwo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flushFibonacciCache() {
    }

}
