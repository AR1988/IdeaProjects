package com.company;


import java.util.Deque;

public class TextHandler extends Thread {


    private static final String OPERATION_NOT_SUPPORTED_EXCEPTION = " operation not supported";
    private static final String WRONG_FORMAT_MESSAGE = " wrong input format";
    private final Deque<String> dequeInput;
    private final Bank bank;
//    private final Deque<String> dequeOutput;

    private final String DELIMETER = "#";
    private String delimiter = DELIMETER;

//    public TextHandler(OperationProvider operationProvider, Deque<String> dequeInput, Deque<String> dequeOutput) {
//        this.operationProvider = operationProvider;
//        this.dequeInput = dequeInput;
//        this.dequeOutput = dequeOutput;
//    }
//
//    public TextHandler(OperationProvider operationProvider, Deque<String> dequeInput, String delimiter, Deque<String> dequeOutput) {
//        this.operationProvider = operationProvider;
//        this.dequeInput = dequeInput;
//        this.dequeOutput = dequeOutput;
//        this.delimiter = delimiter;
//    }

//    public TextHandler(Deque<String> dequeInput, Deque<String> dequeOutput) {
//        this.dequeInput = dequeInput;
//        this.dequeOutput = dequeOutput;
//    }


    /**
     * @param dequeInput source with lines
     * @param bank       source for save after processing
     * @param delimiter  separator/delimiter line
     */
    public TextHandler(Deque<String> dequeInput, Bank bank, String delimiter) {
        this.dequeInput = dequeInput;
        this.bank = bank;
        this.delimiter = delimiter;
    }

    /**
     * @param dequeInput source with lines
     * @param bank       source for save after processing
     *                   separator/delimiter line is default "#"
     */
    public TextHandler(Deque<String> dequeInput, Bank bank) {
        this.dequeInput = dequeInput;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            String line = dequeInput.pollLast();
            if (line == null) {
                return;
            }

            String[] parts = line.split(delimiter);
            if (parts.length != 2) {
                bank.add(line + WRONG_FORMAT_MESSAGE);
                return;
            }

            String text = parts[0];

            String operationName = parts[1];

//            IOperation operation = op.getByName(operationName);
            OperationProvider op = new OperationProvider();

            String res;
            IOperation operation;
            try {
                operation = op.getByName(operationName);
                res = operation.operate(text);
                bank.add(res);
            } catch (OperationNotSupportedException e) {
                bank.add(operationName + OPERATION_NOT_SUPPORTED_EXCEPTION);
            }
        }
    }
}

