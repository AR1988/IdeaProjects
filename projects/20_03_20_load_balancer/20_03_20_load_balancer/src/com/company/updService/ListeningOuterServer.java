package com.company.updService;

import com.company.ServerInfo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.PriorityQueue;

public class ListeningOuterServer implements Runnable {
    DatagramSocket socket;
    PriorityQueue<ServerInfo> source;

    private static final int DATA_SIZE = 1024;

    public ListeningOuterServer(DatagramSocket socket, PriorityQueue<ServerInfo> source) {
        this.socket = socket;
        this.source = source;
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

