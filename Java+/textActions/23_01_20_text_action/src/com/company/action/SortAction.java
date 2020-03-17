package com.company.action;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class SortAction extends TextAction {
    public SortAction(String inputFilename, String outputFilename) throws FileNotFoundException {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
        Collections.sort(content);
    }
}
