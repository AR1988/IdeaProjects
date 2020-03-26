package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    //    final static int PORT = 3020;
    final static int PORT = 3003;
    final static String HOST = "localhost";

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(HOST, PORT);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread thread =
                new Thread(() -> {
                    String line = "Запрос";
                    socketOutput.println(line);
                    try {
                        line = socketInput.readLine();
                        System.out.println("Response from server: " + line);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(thread);
        }
        System.out.println(threadList.toString());
        for (Thread th : threadList) {
            th.start();
            th.join();
        }
        for (Thread th : threadList) {

        }
    }
}

