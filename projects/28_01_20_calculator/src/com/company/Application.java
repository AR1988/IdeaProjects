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

    public static void main(String[] args) throws FileNotFoundException {
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

        String inputFileName = args.length > 0 ? args[0] : INPUT_FILENAME;
        String outputFileName = args.length > 1 ? args[1] : OUTPUT_FILENAME;
//        логическое_условие ? выражение1 : выражение2


        FileOperations fo = new FileOperations();

        List<String> content;
        try {
            content = fo.fileToList(args[0]);
        } catch (IOException e) {
            List<String> error = Arrays.asList("File not found: " + inputFileName);
            fo.listToFile(error, outputFileName);
            return;
        }

        ICalculator calculator = new CharCalculator();
        LineProcessor processor = new LineProcessor(calculator);
        List<String> output = processor.processLines(content);
        fo.listToFile(output, outputFileName);
    }
}
