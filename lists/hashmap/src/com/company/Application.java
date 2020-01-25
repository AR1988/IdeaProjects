package com.company;


import com.company.performance_test.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {

    public static void main(String[] args) throws IOException {
        writeToFile("fileName.txt", 100000, 200);
    }

    private static void writeToFile(String fileName, int repead, int loopRepead) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.append(stringResults(repead, loopRepead));
        writer.close();

        System.out.println("done");
    }

    private static StringBuilder stringResults(int repeat, int loopRepead) {
        PerformanceTest testJava = new JavaHashMapPerformsRule();
        PerformanceTest testOur = new OurHashMapPerformsRule();
        PerformanceTest testNew = new NewHashMapPerformsRule();

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ss:S");

        StringBuilder stringBuilder = new StringBuilder();
        String format = "%10s|%5d|%5d|%5d|\n";

        for (int i = 0; i < loopRepead; i++) {
            stringBuilder.append("............").append(formatForDateNow.format(new Date())).append("...........\n");

            stringBuilder.append(String.format("%10s|%5s|%5s|%5s|\n", " ", "Java", "Our", "New"));
            stringBuilder.append(String.format(format, "Put", testJava.performPut(repeat), testOur.performPut(repeat), testNew.performPut(repeat)));
            stringBuilder.append(String.format(format, "Get", testJava.performGet(), testOur.performGet(), testNew.performGet()));
            stringBuilder.append(String.format(format, "Content", testJava.performContent(), testOur.performContent(), testNew.performContent()));
            stringBuilder.append(String.format(format, "Remove", testJava.performRemove(), testOur.performRemove(), testNew.performRemove()));

            stringBuilder.append(".............................\n");
        }
        return stringBuilder;
    }
}
