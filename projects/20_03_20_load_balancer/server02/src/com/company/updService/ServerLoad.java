package com.company.updService;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerLoad implements Runnable {

    private AtomicInteger serverLoad;
    private int thisServerPort;
    private int loadBalancePort;
    private String loadBalanceIP;

    public ServerLoad(AtomicInteger serverLoad, int thisServerPort, int loadBalancePort, String loadBalanceIP) {
        this.serverLoad = serverLoad;
        this.thisServerPort = thisServerPort;
        this.loadBalancePort = loadBalancePort;
        this.loadBalanceIP = loadBalanceIP;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress loadBalanceServerIP = InetAddress.getByName(loadBalanceIP);

            String line = serverLoad + "_" + thisServerPort;

            byte[] dataOut = line.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOut,
                    dataOut.length,
                    loadBalanceServerIP,
                    loadBalancePort
            );
            socket.send(packetOut);
        } catch (IOException e) {
            return;
        }
    }
}
