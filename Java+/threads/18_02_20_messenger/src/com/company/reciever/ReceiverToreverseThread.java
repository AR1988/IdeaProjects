package com.company.reciever;

import com.company.Messenger;

import java.io.PrintWriter;

public class ReceiverToreverseThread extends Receiver {


    public ReceiverToreverseThread(Messenger message, PrintWriter pw) {
        super(message, pw);
    }

    @Override
    public void run() {
        while (true) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(message.getMessage());
                pw.println(sb.reverse().toString() + "\t" + getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
