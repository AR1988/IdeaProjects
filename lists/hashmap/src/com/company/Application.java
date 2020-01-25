package com.company;

import com.company.performance_test.JavaHashMapPerformsRule;
import com.company.performance_test.NewHashMapPerformsRule;
import com.company.performance_test.OurHashMapPerformsRule;
import com.company.performance_test.PerformanceTest;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss:S");

        PerformanceTest testJava = new JavaHashMapPerformsRule();
        PerformanceTest testOur = new OurHashMapPerformsRule();
        PerformanceTest testNew = new NewHashMapPerformsRule();


        int n = 580000;
        String format = "%1s|%2d|%2s|%2d|%2s|%2d\n";


            System.out.println("Put:");
            System.out.format(format, "Java", testJava.performPut(n), "Our", testOur.performPut(n), "New", testNew.performPut(n));
            System.out.println("Get:");
            System.out.printf(format, "Java", testJava.performGet(), "Our", testOur.performGet(), "New", testNew.performGet());
            System.out.println("Content:");
            System.out.printf(format, "Java", testJava.performContent(), "Our", testOur.performContent(), "New", testNew.performContent());
            System.out.println("Remove");
            System.out.printf(format, "Java", testJava.performRemove(), "Our", testOur.performRemove(), "New", testNew.performRemove());
            System.out.println();

    }
}
