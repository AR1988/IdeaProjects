package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyTask implements Runnable {
    private String outerServerIP;
    private int outerSeverPort;
    private String line;

    public MyTask(String outerServerIP, int outerSeverPort, String line) {
        this.outerServerIP = outerServerIP;
        this.outerSeverPort = outerSeverPort;
        this.line = line;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(outerServerIP, outerSeverPort);

            PrintStream streamOut = new PrintStream(socket.getOutputStream());
            BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            streamOut.println(line);
            String line = streamIn.readLine();

            System.out.println(line);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
