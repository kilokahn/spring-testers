/*
 * ServiceTest.java
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

package com.kilo;

import javax.annotation.Resource;

import org.junit.Test;

import com.kilo.driver.FibonacciService;

//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
public class ServiceTest extends BaseTest {

    @Resource(name = "fibonacciService")
    private FibonacciService fibonacciService;

    @Resource(name = "helper")
    private Helper helper;

    @Test
    public void test1() {
        int nextInteger = helper.getNextInteger();
        long fibonacci = fibonacciService.getFibonacci(nextInteger);
        System.out.println("Fibo for " + nextInteger + " is " + fibonacci);
    }

    @Test
    public void test2() {
        int nextInteger = helper.getNextInteger();
        long fibonacci = fibonacciService.getFibonacci(nextInteger);
        System.out.println("Fibo for " + nextInteger + " is " + fibonacci);
    }

    @Test
    public void test3() {
        int nextInteger = helper.getNextInteger();
        long fibonacci = fibonacciService.getFibonacci(nextInteger);
        System.out.println("Fibo for " + nextInteger + " is " + fibonacci);
    }
}
