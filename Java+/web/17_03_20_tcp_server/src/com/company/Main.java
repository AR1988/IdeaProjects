package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    final static int PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = server.accept();
            Thread thread = new Thread(new ServerAnswer(socket));
            executor.execute(thread);
//            thread.start();
            System.out.println(thread.getName());
        }
    }
}
