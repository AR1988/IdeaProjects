package com.company;

import com.company.operation.LowerCaseOperation;
import com.company.operation.ReverseOperation;
import com.company.operation.UpperCaseOperation;
import com.company.text_action.ReadThread;
import com.company.text_action.TextAction;
import com.company.text_action.WriteThread;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    private static final String FILE_READ_NAME = "inputfile.txt";
    private static final String FILE_WRITE_NAME = "output.txt";

    public static void main(String[] args) throws InterruptedException {

        String inputFilename = args.length > 0 ? args[0] : FILE_READ_NAME;
        String outputFilename = args.length > 1 ? args[1] : FILE_WRITE_NAME;

        Deque<String> outputText = new ConcurrentLinkedDeque<>();
        Deque<String> inputText = new ConcurrentLinkedDeque<>();
        Bank bank = new Bank(new ConcurrentLinkedDeque<>());

        TextAction readFile = new ReadThread(inputFilename, inputText);

        Map<String, IOperation> operationByName = new HashMap<>();
        operationByName.put("lowercase", new LowerCaseOperation());
        operationByName.put("reverse", new ReverseOperation());
        operationByName.put("uppercase", new UpperCaseOperation());

        OperationProvider op = new OperationProvider(operationByName);

        readFile.start();
        readFile.join();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            threads.add(new TextHandler(op, inputText, outputText, bank));
//            threads.add(new TextHandler(inputText, bank));

        for (Thread th : threads)
            th.start();

        for (Thread th : threads)
            th.join();

        TextAction writeFile = new WriteThread(outputFilename, bank);

        writeFile.start();
    }
}
