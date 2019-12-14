package com.company.performance_test;

import com.company.collection.OurList;

public interface ListOperationsStrategy {
    void append(int nTimes);

    OurList getFilledList(int length);

    void get(int nTimes, OurList list);
}
