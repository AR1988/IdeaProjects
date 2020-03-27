package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerAnswer implements Runnable {
    private Socket socket;
    private AtomicInteger serverLoad;

    public ServerAnswer(Socket socket, AtomicInteger serverLoad) {
        this.socket = socket;
        this.serverLoad = serverLoad;
    }

    @Override
    public void run() {
        try {
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());
            System.out.println("new connection");
            String line = socketInput.readLine();
            System.out.println("old line: " + line);
            line = "hello " + line;
            socketOutput.println(line);
            System.out.println("send line: " + line);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverLoad.decrementAndGet();
    }
}
