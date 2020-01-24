package com.company.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ToUpperCaseAction extends TextAction {
    public ToUpperCaseAction(String inputFilename, String outputFilename) throws FileNotFoundException {
        super(inputFilename, outputFilename);
    }

    @Override
    protected void performTask(List<String> content) {
       List<String> tmp = new ArrayList<>(content);

       content.clear();
        for (int i = 0; i < tmp.size() ; i++) {
            content.add(tmp.get(i).toUpperCase());
        }
    }
}
