package com.company;

import com.company.operations.GetOperationName;
import com.company.utils.ReadThread;
import com.company.utils.TextBox;
import com.company.utils.WriteThread;


import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
//        Messenger messenger = new Messenger();
//        Thread senderThread = new SenderThread(messenger);
//        PrintWriter pw = new PrintWriter(new FileWriter("file.txt"));
//
//        List<Thread> receiversList = new ArrayList();
//
//        receiversList.add(new ReceiverThreadToConsole(messenger));
//        receiversList.add(new ReceiverTreadToFile(messenger, pw));
//
//        for (Thread th : receiversList) {
//            th.setDaemon(true);
//        }
//
//        for (Thread th : receiversList) {
//            th.start();
//        }
//
//        senderThread.start();
        GetOperationName gto = new GetOperationName();
        TextBox textBox = new TextBox();
        Thread thRead = new ReadThread("File.txt", textBox, "#", gto);
        Thread thWrite = new WriteThread("outputfile.txt", textBox);

        Queue<Thread> threads = new ConcurrentLinkedQueue<>();

        threads.add(thRead);
        threads.add(thWrite);

        for (Thread th : threads) {
            th.start();
        }

    }
}
