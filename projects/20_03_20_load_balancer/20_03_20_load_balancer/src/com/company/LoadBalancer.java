package com.company;

import com.company.configServices.ConfigReader;
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

public class LoadBalancer {

//    private static final int LOADBALANCER_PORT_FOR_SERVERS = 2014;
//    private static final int LOADBALANCER_PORT_FOR_OUTERSERVER = 2015;

    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String LOADBALANCER_PORT_FOR_SERVERS = "LOADBALANCER_PORT_FOR_SERVERS";
    private static final String LOADBALANCER_PORT_FOR_OUTERSERVER = "LOADBALANCER_PORT_FOR_OUTERSERVER";


    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);

        int portServerListening = Integer.parseInt(configReader.loadParamFromConfig(LOADBALANCER_PORT_FOR_SERVERS));
        int portOuterServerListening = Integer.parseInt(configReader.loadParamFromConfig(LOADBALANCER_PORT_FOR_OUTERSERVER));

        PriorityQueue<ServerInfo> source = new PriorityQueue<>();
        Source serverInfo = new Source(source);

        List<Thread> threads = Arrays.asList(
                new Thread(new ListeningHandlersServer(serverInfo, portServerListening)),
                new Thread(new ListeningOuterServer(serverInfo, portOuterServerListening))
        );
        threads.forEach(Thread::start);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new CheckServerStatus(source), 0, 3, TimeUnit.SECONDS);
    }
}



