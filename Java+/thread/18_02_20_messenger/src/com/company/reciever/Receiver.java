package com.company.reciever;

import com.company.Messenger;

import java.io.PrintWriter;

public abstract class Receiver extends Thread {
    Messenger message;
    PrintWriter pw;

    public Receiver(Messenger message) {
        this.message = message;
    }

    public Receiver(Messenger message, PrintWriter pw) {
        this.message = message;
        this.pw = pw;
    }

    @Override
    public abstract void run();
}
