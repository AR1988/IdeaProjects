package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Main {

    final static int PORT = 3020;
    final static String HOST = "localhost";

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(HOST, PORT);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream socketOutput = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

;
            String line = "hello!";
            socketOutput.println(line);
            line = socketInput.readLine();

        System.out.println(line);
        System.out.println("fin");
        socket.close();
    }
}
