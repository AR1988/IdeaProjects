package com.company;

import com.company.printer.PrintAdapter;

public class PrintTester {
    PrintAdapter pa;

    public PrintTester(PrintAdapter pa) {
        this.pa = pa;
    }

    public long testPrintPerformance(String line, int num) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < num ; i++) {
            pa.println(line);
        }
        pa.close();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
