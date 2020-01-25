package com.company.performance_test;

public abstract class PerformanceTest {

//    private int n;

//    public PerformanceTest(int n) {
//        this.n = n;
//    }

    public abstract long performPut(int n);
    public abstract long performGet();
    public abstract long performContent();
    public abstract long performRemove();
}
