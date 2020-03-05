package com.company.action;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class ReverseAction extends TextAction {
    public ReverseAction(String inputFilename, String outputFilename) throws FileNotFoundException {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
        Collections.reverse(content);
    }
}
