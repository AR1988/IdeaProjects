package com.company.action;

public class PerformanceTest {

    public long perform (){
        long timeNow = System.currentTimeMillis();

        return System.currentTimeMillis() - timeNow;
    }
}
