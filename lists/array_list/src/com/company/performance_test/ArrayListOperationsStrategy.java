package com.company.performance_test;

import com.company.collection.OurArrayList;
import com.company.collection.OurList;

import java.util.Random;

public class ArrayListOperationsStrategy implements ListOperationsStrategy {

    private static final Object object = 10;

    @Override
    public void append(int nTimes) {
        OurList list = new OurArrayList();

        for (int i = 0; i < nTimes; i++) {
            list.append(object);
        }

    }

    @Override
    public OurList getFilledList(int length) {
        OurList list = new OurArrayList();

        for (int i = 0; i < length; i++) {
            list.append(object);
        }
        return list;
    }

    @Override
    public void get(int nTimes, OurList list) {
        for (int i = 0; i < nTimes; i++) {
            for (int j = 0; j < list.size() ; j++) {
                list.get(j);
            }
        }
    }
}
