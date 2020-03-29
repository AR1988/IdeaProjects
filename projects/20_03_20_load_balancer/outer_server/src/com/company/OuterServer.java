package com.company;

import com.company.service.ConfigReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OuterServer {

    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String OUTER_SERVER_PORT = "OUTER_SERVER_PORT";

    private static final String LOADBALANCE_PORT_FOR_OUTERSERVER = "LOADBALANCE_PORT_FOR_OUTERSERVER";
    private static final String LOADBALANCE_IP = "LOADBALANCE_IP";

    private static final String DATA_SIZE_TO_RECIVE = "DATA_SIZE_TO_RECIVE";
    private static final String GET_THREADS_OUTERSERVER = "THREADS_OUTERSERVER";

    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);
        int port = Integer.parseInt(configReader.loadParamFromConfig(OUTER_SERVER_PORT));
        int executorThreads = Integer.parseInt(configReader.loadParamFromConfig(GET_THREADS_OUTERSERVER));

        String loadBalanceIP = configReader.loadParamFromConfig(LOADBALANCE_IP);
        int loadBalancePort = Integer.parseInt(configReader.loadParamFromConfig(LOADBALANCE_PORT_FOR_OUTERSERVER));
        int dataSize = Integer.parseInt(configReader.loadParamFromConfig(DATA_SIZE_TO_RECIVE));

        ServerSocket server = new ServerSocket(port);
        ExecutorService executor = Executors.newFixedThreadPool(executorThreads);

        System.out.println(".........\n"
                + "loading param from:\t"
                + FILE_DIRECTORY
                + "\n.........");

        while (true) {
            Socket socket = server.accept(); // принимаем соеденение
            ServerRequest serverTask = new ServerRequest(socket, loadBalanceIP, loadBalancePort, dataSize); // новым потоком перенаправляем
            executor.execute(serverTask); //запускаем поток
        }
    }
}
