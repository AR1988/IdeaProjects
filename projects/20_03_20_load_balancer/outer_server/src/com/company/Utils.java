package com.company;

import java.io.IOException;
import java.net.*;

public class Utils {
    private static final int DATA_SIZE = 1024;
    private final static int SERVER_PORT = 2015; //порт куда кидать сообщение
    private final static String SERVER_HOST = "localhost"; // адрес куда кида кидать сообщение

    private DatagramSocket socket;

    //регион конструкторов
    //#region constructor

    public Utils() throws SocketException {
        this.socket = new DatagramSocket(SERVER_PORT);
    }

    public Socket bestServerLoad() throws IOException {
        InetAddress serverIP = InetAddress.getByName(SERVER_HOST);

        String line = "request";
        byte[] dataOut = line.getBytes();

        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                serverIP,
                SERVER_PORT
        );
        socket.send(packetOut);
        System.out.println("38");

        byte[] dataToReceive = new byte[DATA_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataToReceive, DATA_SIZE);
        try {
            this.socket.receive(packetIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        line = new String(dataToReceive, 0, packetIn.getLength());
        String[] strings = line.split("_");
        System.out.println("paket: " + line);
        socket.close();

        return new Socket(strings[0], Integer.parseInt(strings[1]));
    }
}
