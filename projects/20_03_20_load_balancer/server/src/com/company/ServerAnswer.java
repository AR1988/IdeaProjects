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
    private int serverName;

    public ServerAnswer(Socket socket, AtomicInteger serverLoad, int serverName) {
        this.socket = socket;
        this.serverLoad = serverLoad;
        this.serverName = serverName;
    }

    @Override
    public void run() {
        try {
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());
            String line = socketInput.readLine();
            line = "Answer from server NR: " + serverName + "\tresult: " + line.toUpperCase();
            socketOutput.println(line);
            System.out.println(line);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverLoad.decrementAndGet();
    }
}
