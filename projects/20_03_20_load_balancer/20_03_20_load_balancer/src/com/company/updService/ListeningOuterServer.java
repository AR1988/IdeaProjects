package com.company.updService;

import com.company.ServerInfo;
import com.company.Source;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.PriorityQueue;

public class ListeningOuterServer implements Runnable {
    Source source;
    int port;
    private static final int DATA_SIZE = 1024;
    DatagramSocket socket;

    public ListeningOuterServer(Source source, int port) throws SocketException {
        this.source = source;
        this.port = port;
        this.socket = new DatagramSocket(port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] dataToReceive = new byte[DATA_SIZE];
                DatagramPacket packetIn = new DatagramPacket(dataToReceive, DATA_SIZE);
                socket.receive(packetIn);
                String address = source.peek().toString();
                //send the data back
                byte[] dataToSendBack = address.split("/")[1].getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        dataToSendBack,
                        dataToSendBack.length,
                        packetIn.getAddress(),
                        packetIn.getPort());
                socket.send(packetOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

