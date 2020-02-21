package com.company.utils;

import com.company.operations.GetOperationName;
import com.company.operations.OperationNotSupportedException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadThread extends Thread {

    String inputFilename;
    TextBox textBox;
    GetOperationName getOperationName;

    String splitChar;

    public ReadThread(String inputFilename, TextBox textBox, String splitChar, GetOperationName getOperationName) {
        this.inputFilename = inputFilename;
        this.textBox = textBox;
        this.splitChar = splitChar;
        this.getOperationName = getOperationName;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename))) {
            String res = br.readLine();

            List<String> strings = new ArrayList<>(Arrays.asList(res.split(splitChar)));

            textBox.addElt(strings.get(0));
            getOperationName.addOperation(strings.get(0), strings.get(1));

        } catch (IOException | OperationNotSupportedException e) {
            return;
        }
    }
}





