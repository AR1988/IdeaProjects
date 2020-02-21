package com.company.reciever;

import com.company.Messenger;

import java.io.PrintWriter;

public class ReceiverThreadToConsole extends Receiver {


    public ReceiverThreadToConsole(Messenger message) {
        super(message);
    }

    public ReceiverThreadToConsole(Messenger message, PrintWriter pw) {
        super(message, pw);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = message.getMessage();
                System.out.println(line + " " + getName());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
