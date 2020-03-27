package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    final static int PORT = 3003;

    public static void main(String[] args) throws IOException {
        AtomicInteger serverLoad = new AtomicInteger(0);

        ServerSocket server = new ServerSocket(PORT);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Thread serverLoadThread = new Thread(new ServerLoad(serverLoad));
        serverLoadThread.start();

        while (true) {
            Socket socket = server.accept();
            System.out.println("new connection!");
            serverLoad.incrementAndGet();
            Runnable serverTask = new ServerAnswer(socket, serverLoad);

            executor.execute(serverTask);
        }
    }


    public static int getPORT() {
        return PORT;
    }
}
