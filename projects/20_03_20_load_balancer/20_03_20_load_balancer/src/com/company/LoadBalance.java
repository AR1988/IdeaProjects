package com.company;

import com.company.configServices.ConfigReader;
import com.company.reserve_server.ReserveServer;
import com.company.updService.CheckServerStatus;
import com.company.updService.ListeningHandlersServer;
import com.company.updService.ListeningOuterServer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadBalance {
    private static final String CONFIG_FILE_DIRECTORY = "config/config.props";

    private static final String LOADBALANCE_PORT_FOR_SERVERS = "LOADBALANCE_PORT_FOR_SERVERS";
    private static final String LOADBALANCE_PORT_FOR_OUTERSERVER = "LOADBALANCE_PORT_FOR_OUTERSERVER";

    private static final String DATA_SIZE_TO_RECIVE = "DATA_SIZE_TO_RECIVE";
    private static final String THREADS_FOR_LISTENING_SERVER = "THREADS_FOR_LISTENING_SERVER";
    private static final String THREADS_FOR_LISTENING_OUTERSERVER = "THREADS_FOR_LISTENING_OUTERSERVER";

    private static final String RESERVE_SERVER_PORT = "RESERVE_SERVER_PORT";
    private static final String RESERVE_SERVER_NAME = "RESERVE_SERVER_NAME";

    private static final String MAX_DIED_TIME_SERVERS = "MAX_DIED_TIME_SERVERS";


    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader(CONFIG_FILE_DIRECTORY);

        int portServerListening = Integer.parseInt(configReader.loadParamFromConfig(LOADBALANCE_PORT_FOR_SERVERS));
        int portOuterServerListening = Integer.parseInt(configReader.loadParamFromConfig(LOADBALANCE_PORT_FOR_OUTERSERVER));

        int dataSizeToRecive = Integer.parseInt(configReader.loadParamFromConfig(DATA_SIZE_TO_RECIVE));

        int threadsForListeningServer = Integer.parseInt(configReader.loadParamFromConfig(THREADS_FOR_LISTENING_SERVER));
        int threadsForListeningOuterServer = Integer.parseInt(configReader.loadParamFromConfig(THREADS_FOR_LISTENING_OUTERSERVER));

        int reserveServerPort = Integer.parseInt(configReader.loadParamFromConfig(RESERVE_SERVER_PORT));
        String reserveServerName = configReader.loadParamFromConfig(RESERVE_SERVER_NAME);

        long updateTime = Long.parseLong(configReader.loadParamFromConfig(MAX_DIED_TIME_SERVERS));
        PriorityQueue<ServerInfo> source = new PriorityQueue<>();
        Source serverInfo = new Source(source);

        System.out.println(".........\n"
                + "loading param from:\t"
                + CONFIG_FILE_DIRECTORY
                + "\n.........");

        List<Thread> threads = Arrays.asList(
                new Thread(new ListeningHandlersServer(serverInfo, portServerListening, threadsForListeningServer, dataSizeToRecive)),
                new Thread(new ListeningOuterServer(serverInfo, portOuterServerListening, threadsForListeningOuterServer, dataSizeToRecive)),
                new Thread(new ReserveServer(reserveServerPort, reserveServerName))
        );
        threads.forEach(Thread::start);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new CheckServerStatus(source, updateTime), updateTime, updateTime, TimeUnit.SECONDS);
    }
}



