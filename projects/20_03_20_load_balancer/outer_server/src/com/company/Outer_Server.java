package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Outer_Server {

    final static int PORT = 3020;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = server.accept(); // принимаем соеденение
            System.out.println("new connection!"); //проверям пришло соеденение
            Runnable serverTask = new Thread(new ServerRequest(socket)); // новым потоком перенаправляем
            executor.execute(serverTask); //запускаем поток

        }
    }
}
