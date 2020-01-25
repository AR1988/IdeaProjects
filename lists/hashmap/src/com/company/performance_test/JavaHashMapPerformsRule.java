package com.company.performance_test;

import java.util.HashMap;

public class JavaHashMapPerformsRule extends PerformanceTest {
    HashMap<Integer, Integer> jhm = new HashMap<>();

//    public JavaHashMapPerformsRule(int n) {
//        super(n);
//    }

    @Override
    public long performPut(int n) {
        long timeNow = System.currentTimeMillis();
            fillHashmap(n);
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performGet() {

        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < jhm.size(); i++) {
            j++;
            jhm.get(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performContent() {
        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < jhm.size(); i++) {
            j++;
            jhm.containsKey(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performRemove() {
        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < jhm.size(); i++) {
            j++;
            jhm.remove(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    private void fillHashmap(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            j++;
            jhm.put(j, i);
        }
    }
}
