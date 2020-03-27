package com.company;

import com.company.updService.CheckServerStatus;
import com.company.updService.ListeningHandlersServer;
import com.company.updService.ListeningOuterServer;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadBalancer {

    private static final int SERVER_PORT = 2014;
    private static final int OUTERSERVER_PORT = 2015;

    public static void main(String[] args) throws IOException {
        PriorityQueue<ServerInfo> source = new PriorityQueue<>();
        Source serverInfo = new Source(source);

        DatagramSocket listeningServerLoad = new DatagramSocket(SERVER_PORT);
        DatagramSocket listeningOuterServer = new DatagramSocket(OUTERSERVER_PORT);

        List<Thread> threads = Arrays.asList(
                new Thread(new ListeningHandlersServer(listeningServerLoad, serverInfo)),
                new Thread(new ListeningOuterServer(listeningOuterServer, serverInfo))
        );
        threads.forEach(Thread::start);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new CheckServerStatus(source), 0, 3, TimeUnit.SECONDS);
    }
}



