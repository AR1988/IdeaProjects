package com.company;

import com.company.configServices.ConfigReader;
import com.company.updService.ServerLoad;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String SERVER_2_PORT = "SERVER_2_PORT";
    private static final String SERVER_2_NAME = "SERVER_2_NAME";
    private static final String SERVER_2_THREADS = "SERVER_2_THREADS";
    private static final String START_LOAD_SERV_2 = "START_LOAD_SERV_2";
    private static final String LOAD_UPDATE_TIME = "LOAD_UPDATE_TIME";
    private static final String LOADBALANCE_PORT_FOR_SERVERS = "LOADBALANCE_PORT_FOR_SERVERS";
    private static final String LOADBALANCE_IP = "LOADBALANCE_IP";


    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);

        int portServer1 = Integer.parseInt(configReader.loadParamFromConfig(SERVER_2_PORT));
        int startLoad = Integer.parseInt(configReader.loadParamFromConfig(START_LOAD_SERV_2));
        String serverName2 = configReader.loadParamFromConfig(SERVER_2_NAME);
        int nThreads = Integer.parseInt(configReader.loadParamFromConfig(SERVER_2_THREADS));
        long timeForUpdate = Integer.parseInt(configReader.loadParamFromConfig(LOAD_UPDATE_TIME));
        int loadBalancePort = Integer.parseInt(configReader.loadParamFromConfig(LOADBALANCE_PORT_FOR_SERVERS));
        String loadBalanceIP = configReader.loadParamFromConfig(LOADBALANCE_IP);

        AtomicInteger serverLoad = new AtomicInteger(startLoad);
        ServerSocket server1 = new ServerSocket(portServer1);
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new ServerLoad(serverLoad,
                portServer1,
                loadBalancePort,
                loadBalanceIP), timeForUpdate, timeForUpdate, TimeUnit.MILLISECONDS);

        while (true) {
            Socket socket = server1.accept();
            serverLoad.incrementAndGet();
            ServerAnswer serverTask = new ServerAnswer(socket, serverLoad, serverName2);

            executor.execute(serverTask);
        }
    }
}
