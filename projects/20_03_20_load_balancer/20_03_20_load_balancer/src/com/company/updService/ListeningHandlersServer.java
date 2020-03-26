package com.company.updService;

import com.company.ServerInfo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListeningHandlersServer implements Runnable {
    DatagramSocket socket;
    //    PriorityQueue<ServerInfo> source;
    ConcurrentLinkedQueue<ServerInfo> source;

    private static final int DATA_SIZE = 1024;

    public ListeningHandlersServer(DatagramSocket socket, ConcurrentLinkedQueue<ServerInfo> source) {
        this.socket = socket;
        this.source = source;
    }

    @Override
    public void run() {
        while (true) {
            byte[] dataToReceive = new byte[DATA_SIZE];
            DatagramPacket packetIn = new DatagramPacket(dataToReceive, DATA_SIZE);
            try {
                this.socket.receive(packetIn);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String line = new String(dataToReceive, 0, packetIn.getLength());
            String[] strings = line.split("_");

            //загрузка сервера
            int serverLoad = Integer.parseInt(strings[0]);
            //IP сервера
            InetAddress serverIp = packetIn.getAddress();
            //порт сервера
            int serverPort = Integer.parseInt(strings[1]);
            //положить в структуру данных
            //3 артрк проверяет все серваки на доступность
            System.out.println(serverLoad + " port: " + serverPort);
            source.add(new ServerInfo(serverIp, serverPort, serverLoad));
        }
    }
}
