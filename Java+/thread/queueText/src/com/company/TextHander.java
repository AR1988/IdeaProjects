package com.company;

import java.util.Deque;

public class TextHander extends Thread {
    private OperationProvider op;
    private Deque<String> source;

    private String delimiter = "#";

    public TextHander(OperationProvider op, Deque<String> source) {
        this.op = op;
        this.source = source;
    }

    @Override
    public void run() {
        String line = source.pollLast();
        if (source.pollLast() == null)
            return;

        String[] strings = line.split(delimiter);

        String operationText = strings[0];
        String operationName = strings[1];

        IOperation IOperation = op.getByName(operationName);

        op.getByName(operationText);
    }
}

