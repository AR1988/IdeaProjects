package com.company.reciever;

import com.company.Messenger;

import java.io.PrintWriter;

public class ReceiverToUpperCaseThread extends Receiver {


    public ReceiverToUpperCaseThread(Messenger message, PrintWriter pw) {
        super(message, pw);
    }

    @Override
    public void run() {
        while (true) {
            try {
                pw.println(message.getMessage().toUpperCase() + "\t" + getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
