
package com.kilo;

public class Helper {

    private static int currentNum = 2;

    public void init() {
        System.out.println("Inited helper");
    }

    public int getNextInteger() {
        return currentNum++;
    }
}
