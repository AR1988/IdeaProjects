package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Load_balance {

    private static final int PORT = 2014;
    private static final int DATA_SIZE = 1024;

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(PORT);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Map<Integer, ServerInfo> serverInfoMap = new TreeMap<>();
        LoadSource loadSource;

        while (true) {
            byte[] dataToReceive = new byte[DATA_SIZE];
            DatagramPacket packetIn = new DatagramPacket(dataToReceive, DATA_SIZE);
            socket.receive(packetIn);

            String line = new String(dataToReceive, 0, packetIn.getLength());
            String[] strings = line.split("_");

            //загрузка сервера
            int serverLoad = Integer.parseInt(strings[0]);
            //IP сервера
            InetAddress serverIp = packetIn.getAddress();
            //порт сервера
            int serverPort = Integer.parseInt(strings[1]);

            loadSource = new LoadSource(new ServerInfo(serverIp, serverPort), serverLoad, serverInfoMap);

//                System.out.println(serverInfoMap.toString());
        }
    }
}


