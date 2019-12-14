package com.company;

import com.company.collection.OurArrayList;
import com.company.collection.OurLinkedList;
import com.company.object.Employee;
import com.company.object.Manager;
import com.company.object.Worker;
import com.company.performance_test.ArrayListOperationsStrategy;
import com.company.performance_test.LinkedListOperationsStrategy;
import com.company.performance_test.ListOperationsStrategy;
import com.company.performance_test.ListPerformanceTester;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Application {

    public static void main(String[] args) {

        ListOperationsStrategy arrayStrategy = new ArrayListOperationsStrategy();
        ListOperationsStrategy linkedStrategy = new LinkedListOperationsStrategy();


        ListPerformanceTester arrayTester = new ListPerformanceTester(arrayStrategy);
        ListPerformanceTester linkedTester = new ListPerformanceTester(linkedStrategy);

        System.out.println(arrayTester.testAppendPerformance(10000000));
        System.out.println(linkedTester.testAppendPerformance(10000000));

        System.out.println(arrayTester.testGetPerformance(1000000, 1000));
        System.out.println(linkedTester.testGetPerformance(1000000, 1000));
    }
}
