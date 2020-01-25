package com.company.performance_test;

import com.company.collections.NewHashMap;

import java.util.HashMap;

public class NewHashMapPerformsRule extends PerformanceTest {
    NewHashMap<Integer, Integer> nhm = new NewHashMap<>();

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
        for (int i = 0, j = 0; i < nhm.size(); i++) {
            j++;
            nhm.get(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performContent() {
        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < nhm.size(); i++) {
            j++;
            nhm.contains(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performRemove() {
        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < nhm.size(); i++) {
            j++;
            nhm.remove(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    public void fillHashmap(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            j++;
            nhm.put(j, i);
        }
    }
}
