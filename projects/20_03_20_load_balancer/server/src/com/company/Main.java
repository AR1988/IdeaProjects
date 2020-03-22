package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    final static int PORT = 3033;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        Runnable serverLoad = new ServerLoad();
        executor.execute(serverLoad);

        while (true) {
            Socket socket = server.accept();
            System.out.println("new connection!");
            Runnable serverTask = new ServerAnswer(socket);
            executor.execute(serverTask);
        }
    }
}
