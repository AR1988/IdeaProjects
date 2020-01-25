package com.company.performance_test;

import com.company.collections.NewHashMap;

public class OurHashMapPerformsRule extends PerformanceTest {
    NewHashMap<Integer,Integer> ohm = new NewHashMap<>();

//    public OurHashMapPerformsRul(int n) {
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
        for (int i = 0, j = 0; i < ohm.size(); i++) {
            j++;
            ohm.get(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performContent() {
        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < ohm.size(); i++) {
            j++;
            ohm.contains(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    @Override
    public long performRemove() {
        long timeNow = System.currentTimeMillis();
        for (int i = 0, j = 0; i < ohm.size(); i++) {
            j++;
            ohm.remove(j);
        }
        return System.currentTimeMillis() - timeNow;
    }

    public void fillHashmap(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            j++;
            ohm.put(j, i);
        }
    }
}
