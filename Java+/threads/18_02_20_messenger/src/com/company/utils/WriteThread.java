package com.company.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteThread extends Thread {
    String outputFilename;
    TextBox textBox;

    public WriteThread(String outputFilename, TextBox textBox) {
        this.outputFilename = outputFilename;
        this.textBox = textBox;
    }

    @Override
    public void run() {
        try (PrintWriter pw = new PrintWriter(outputFilename)) {
            pw.println(textBox.getElt());
        } catch (FileNotFoundException | InterruptedException e) {
            return;
        }
    }
}

