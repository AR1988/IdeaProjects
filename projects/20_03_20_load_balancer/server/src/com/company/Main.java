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

    //    final static int PORT = 3003;
    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String SERVER_PORT = "SERVER_1_PORT";

    public static void main(String[] args) throws IOException {
        AtomicInteger serverLoad = new AtomicInteger(0);

        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);
        int portServer = Integer.parseInt(configReader.loadParamFromConfig(SERVER_PORT));

        ServerSocket server = new ServerSocket(portServer);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Thread serverLoadThread = new Thread(new ServerLoad(serverLoad, portServer,configReader));
        serverLoadThread.start();

        while (true) {
            Socket socket = server.accept();
            System.out.println("new connection!");
            serverLoad.incrementAndGet();
            Runnable serverTask = new ServerAnswer(socket, serverLoad);

            executor.execute(serverTask);
        }
    }
}
