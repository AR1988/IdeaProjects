package com.company;

import com.company.updService.ListeningOuterServer;
import com.company.updService.ListeningHandlersServer;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LoadBalancer {

    private static final int SERVER_PORT = 2014;
    private static final int OUTERSERVER_PORT = 2015;

    public static void main(String[] args) throws IOException {

//        PriorityQueue<ServerInfo> source = new PriorityQueue<>();
        ConcurrentLinkedQueue<ServerInfo> source = new ConcurrentLinkedQueue();

        DatagramSocket listeningServerLoad = new DatagramSocket(SERVER_PORT);
        DatagramSocket listeningOuterServer = new DatagramSocket(OUTERSERVER_PORT);

        List<Thread> threads = Arrays.asList(
                new Thread(new ListeningHandlersServer(listeningServerLoad, source)),
                new Thread(new ListeningOuterServer(listeningOuterServer, source)),
                new Thread(new CheckServersStatus(source))
        );
        ConcurrentLinkedQueue<Thread> concurrentLinkedQueue = new ConcurrentLinkedQueue(threads);

        concurrentLinkedQueue.forEach(Thread::start);

    }
}



