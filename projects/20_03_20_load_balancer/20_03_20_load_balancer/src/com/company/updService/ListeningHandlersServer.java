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
    DatagramSocket socket;
    int port;
    Source source;
    private static final int DATA_SIZE = 1024;

    public ListeningHandlersServer(Source source, int port) throws SocketException {
        this.source = source;
        this.port = port;
        this.socket = new DatagramSocket(port);
    }

    @Override
    public void run() {
        //завести экзикютор
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        while (true) {
            try {
                byte[] dataToReceive = new byte[DATA_SIZE];
                DatagramPacket packetIn = new DatagramPacket(dataToReceive, DATA_SIZE);
                this.socket.receive(packetIn);
                executorService.execute(() -> {
                    String line = new String(dataToReceive, 0, packetIn.getLength());
                    String[] strings = line.split("_");
                    System.out.println(line);
                    int serverLoad = Integer.parseInt(strings[0]);
                    InetAddress serverIp = packetIn.getAddress();
                    int serverPort = Integer.parseInt(strings[1]);
                    source.add(new ServerInfo(serverIp, serverPort, serverLoad));
                    System.out.println("port: " + serverPort + "\tload:" + serverLoad);
                });

            } catch (IOException e) {
                continue;
            }
        }
    }
}
