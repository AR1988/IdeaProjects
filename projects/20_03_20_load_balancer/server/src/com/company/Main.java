package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    final static int PORT = 3003;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        Runnable serverLoad = new ServerLoad();
        executor.execute(serverLoad);

        while (true) {
            System.out.println(Thread.activeCount());
            Socket socket = server.accept();
            System.out.println("new connection!");
            Runnable serverTask = new ServerAnswer(socket);
            executor.execute(serverTask);

               System.out.println(Thread.activeCount());
        }
    }

    public static int getPORT() {
        return PORT;
    }
}
