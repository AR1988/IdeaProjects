package com.company.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class TextAction {

    private String inputFilename;
    private String outputFilename;

    public TextAction(String inputFilename, String outputFilename) throws FileNotFoundException {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
    }

    public void perform() throws IOException {
        List<String> content = readFromFile(inputFilename);

        //something happens

        performTask(content);
        writeToFile(content);
    }

    protected abstract void performTask(List<String> content);

    private void writeToFile(List<String> content) throws IOException {
        PrintWriter printWriter = new PrintWriter(outputFilename);

        try {
            for (String line : content) {
                printWriter.println(line);
            }
        } finally {
            printWriter.close();
        }
    }

    private List<String> readFromFile(String inputFilename) throws IOException {

        List<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFilename));

        String in;

        while ((in = br.readLine()) != null) {
            result.add(in);
        }
        br.close();
        return result;
    }
}
