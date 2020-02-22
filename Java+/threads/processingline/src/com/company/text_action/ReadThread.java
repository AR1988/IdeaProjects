package com.company.text_action;

import java.io.*;
import java.util.Deque;

public class ReadThread extends TextAction {

    private static final String INPUTFILENAME = "input.txt";
    private String inputFileName = INPUTFILENAME;
    private final Deque<String> deque;

    /**
     * @param fileInputName file name
     * @param deque data source
     */
    public ReadThread(String fileInputName, Deque<String> deque) {
        this.inputFileName = fileInputName;
        this.deque = deque;
    }

    /**
     * @param deque data source
     *              file name is default = "input.txt"
     */
    public ReadThread(Deque<String> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                deque.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
