package com.company.updService;

import com.company.ServerInfo;
import com.company.Source;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListeningHandlersServer implements Runnable {
    private Source source;
    private DatagramSocket socket;
    int threads;
    private int dataSize;

    public ListeningHandlersServer(Source source, int port, int threads, int dataSize) throws SocketException {
        this.source = source;
        this.socket = new DatagramSocket(port);
        this.threads = threads;
        this.dataSize = dataSize;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        while (true) {
            try {
                byte[] dataToReceive = new byte[dataSize];
                DatagramPacket packetIn = new DatagramPacket(dataToReceive, dataSize);
                this.socket.receive(packetIn);
                ReceiveTask task = new ReceiveTask(source, packetIn, dataToReceive);
                executorService.execute(task);

            } catch (IOException e) {
                continue;
            }
        }
    }
}

class ReceiveTask implements Runnable {
    private Source source;
    private DatagramPacket packetIn;
    private byte[] dataToReceive;

    public ReceiveTask(Source source, DatagramPacket packetIn, byte[] dataToReceive) {
        this.source = source;
        this.packetIn = packetIn;
        this.dataToReceive = dataToReceive;
    }

    @Override
    public void run() {
        String line = new String(dataToReceive, 0, packetIn.getLength());
        String[] strings = line.split("_");

        int serverLoad = Integer.parseInt(strings[0]);
        InetAddress serverIp = packetIn.getAddress();
        int serverPort = Integer.parseInt(strings[1]);

        source.add(new ServerInfo(serverIp, serverPort, serverLoad));
        System.out.println("port: " + serverPort + "\tload: " + serverLoad + "\tsize: " + source.size());
    }
}
