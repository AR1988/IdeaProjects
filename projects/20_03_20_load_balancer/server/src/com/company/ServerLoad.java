package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerLoad implements Runnable {

    private final static int SERVER_PORT = 2014; //порт куда кидать сообщение
    private final static String SERVER_HOST = "localhost"; // адрес куда кида кидать сообщение

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getByName(SERVER_HOST);

            while (true) {
                dataSend(socket, serverIP, String.valueOf(Thread.activeCount()));
                Thread.sleep(3000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void dataSend(DatagramSocket socket, InetAddress serverIP, String line) throws IOException {

        byte[] dataOut = line.getBytes();
        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                serverIP,
                SERVER_PORT
        );
        socket.send(packetOut);

    }
}
