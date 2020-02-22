package com.company.text_action;

import com.company.Bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteThread extends TextAction {

//    private final Deque<String> deque;

    private final String FILEOUTPUTNAME = "output.txt";
    private String outputFileName = FILEOUTPUTNAME;
    private final Bank bank;

//    public WriteThread(Deque<String> deque) {
//        this.deque = deque;
//    }
//
//    public WriteThread(String outputFileName, Deque<String> deque) {
//        this.outputFileName = outputFileName;
//        this.deque = deque;
//    }

    /**
     * @param outputFileName file name
     * @param bank data source
     */
    public WriteThread(String outputFileName, Bank bank) {
        this.outputFileName = outputFileName;
        this.bank = bank;
    }
    /**
     * @param bank data source
     *              file name is default = "output.txt"
     */
    public WriteThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
            while (bank.size() > 0)
                bw.write(bank.get() + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
