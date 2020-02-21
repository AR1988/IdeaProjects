package com.company.reciever;

import com.company.Messenger;

import java.io.PrintWriter;

public class ReceiverTreadToFile extends Receiver {

    public ReceiverTreadToFile(Messenger message, PrintWriter pw) {
        super(message, pw);
    }

    @Override
    public void run() {
        while (true) {
            try {
                pw.println(message.getMessage() + "\t" + getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
