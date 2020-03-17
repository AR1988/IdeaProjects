package com.company;

import com.company.printer.PrintAdapter;
import com.company.printer.PrintStreamAdapter;
import com.company.printer.PrintWriterAdapter;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        PrintAdapter pwa = new PrintWriterAdapter(new PrintWriter("test_pwa"));
        PrintAdapter psa = new PrintStreamAdapter(new PrintStream("test_psa"));

        PrintTester printTester01 = new PrintTester(pwa);
        PrintTester printTester02 = new PrintTester(psa);

        System.out.println("test PrintWriter: " + printTester01.testPrintPerformance("hello", 100000));
        System.out.println("test Printstream: " + printTester02.testPrintPerformance("hello", 100000));
    }
}
