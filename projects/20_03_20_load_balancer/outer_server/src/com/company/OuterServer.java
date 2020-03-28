package com.company;

import com.company.service.ConfigReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OuterServer {

    //    final static int PORT = 3021;
    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String OUTER_SERVER_PORT = "OUTER_SERVER_PORT";


    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);
        int port = Integer.parseInt(configReader.loadParamFromConfig(OUTER_SERVER_PORT));

        ServerSocket server = new ServerSocket(port);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = server.accept(); // принимаем соеденение
            System.out.println("new connection!"); //проверям пришло соеденение
            Runnable serverTask = new Thread(new ServerRequest(socket)); // новым потоком перенаправляем
            executor.execute(serverTask); //запускаем поток

        }
    }
}
