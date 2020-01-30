package com.company;

import com.company.calculator.CharCalculator;
import com.company.calculator.ICalculator;
import com.company.calculator.LineProcessor;
import com.company.util.FileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";

    public static void main(String[] args) {
//        FileOperations fo = new FileOperations();
//
//        List<String> content;
//        try {
//            content = fo.fileToList(INPUT_FILENAME);
//        } catch (IOException e) {
//            List<String> error = Arrays.asList("File not found: " + INPUT_FILENAME);
//            fo.listToFile(error, OUTPUT_FILENAME);
//            return;
//        }
//
//        ICalculator calculator = new CharCalculator();
//        LineProcessor processor = new LineProcessor(calculator);
//        List<String> output = processor.processLines(content);
//        fo.listToFile(output, OUTPUT_FILENAME);

        List<String> content = Arrays.asList("a + 1", "2 + 2");

        ICalculator calculator = new CharCalculator();
        LineProcessor processor = new LineProcessor(calculator);

        List<String> result = processor.processLines(content);
        System.out.println(result);

    }
}
