package com.company.reserve_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReserveServer implements Runnable {

    private int serverPort;
    private String serverName;

    public ReserveServer(int serverPort, String serverName) {
        this.serverPort = serverPort;
        this.serverName = serverName;
    }

    @Override
    public void run() {
        try {
            ServerSocket server1 = new ServerSocket(serverPort);

            while (true) {
                Socket socket = server1.accept();
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());

                String line = socketInput.readLine();
                line = "Answer from server NR: " + serverName + "\tresult: " + line.toUpperCase();
                socketOutput.println(line);
                System.out.println(line);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



