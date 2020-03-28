package com.company;

import com.company.configServices.ConfigReader;
import com.company.updService.ServerLoad;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String SERVER_1_PORT = "SERVER_1_PORT";


    public static void main(String[] args) throws IOException {
        AtomicInteger serverLoad = new AtomicInteger(0);

        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);
        int portServer1 = Integer.parseInt(configReader.loadParamFromConfig(SERVER_1_PORT));

        ServerSocket server1 = new ServerSocket(portServer1);

        Thread serverLoadThread = new Thread(new ServerLoad(serverLoad, portServer1, configReader));
        serverLoadThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = server1.accept();
            serverLoad.incrementAndGet();
            ServerAnswer serverTask = new ServerAnswer(socket, serverLoad, 1);

            executor.execute(serverTask);
        }
    }
}
