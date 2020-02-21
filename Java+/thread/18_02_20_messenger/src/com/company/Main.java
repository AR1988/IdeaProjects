package com.company;

import com.company.reciever.ReceiverThreadToConsole;
import com.company.reciever.ReceiverToUpperCaseThread;
import com.company.reciever.ReceiverToreverseThread;
import com.company.reciever.ReceiverTreadToFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Messenger messenger = new Messenger();
        Thread senderThread = new SenderThread(messenger);

        PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true));

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threadList.add(new ReceiverThreadToConsole(messenger));
            threadList.add(new ReceiverTreadToFile(messenger, pw));
            threadList.add(new ReceiverToreverseThread(messenger, pw));
            threadList.add(new ReceiverToUpperCaseThread(messenger, pw));
        }

        senderThread.start();

        for (Thread th : threadList)
            th.setDaemon(true);

        for (Thread th : threadList)
            th.start();

        senderThread.join();
        pw.close();
    }
}
