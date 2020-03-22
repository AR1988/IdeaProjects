package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerAnswer implements Runnable {
    private Socket socket;

    public ServerAnswer(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        System.out.println("connected: " + socket.isConnected());
        try {
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());

            String line;
            while ((line = socketInput.readLine()) != null) {
                line = "hello " + line;
                socketOutput.println(line);
            }
            socket.close();
            System.out.println("socket closed: " + socket.isClosed());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
