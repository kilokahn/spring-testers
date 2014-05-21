
package com.kilo;

import javax.annotation.Resource;

import org.junit.Test;

import com.kilo.driver.FibonacciService;

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
