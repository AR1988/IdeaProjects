package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Load_balancer {

    private static final int PORT = 2014;
    private static final int DATA_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(PORT);

        while (true) {
            byte[] dataToReceive = new byte[DATA_SIZE];
            DatagramPacket packetIn = new DatagramPacket(
                    dataToReceive,
                    DATA_SIZE
            );
            socket.receive(packetIn);

            String line = new String(dataToReceive, 0, packetIn.getLength());
            //загрузка сервера
            int serverLoad = Integer.parseInt(line);
            //IP сервера
            InetAddress serverIp = packetIn.getAddress();
            //порт сервера
            int serverPort = packetIn.getPort();

        }
    }
}


