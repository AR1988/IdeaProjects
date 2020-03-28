package com.company.updService;

import com.company.configServices.ConfigReader;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerLoad implements Runnable {

    private AtomicInteger serverLoad;
    private int thisServerPort;
    int loadBalancePort;
    String loadBalanceIP;

    public ServerLoad(AtomicInteger serverLoad, int thisServerPort, ConfigReader configReader) throws IOException {
        this.serverLoad = serverLoad;
        this.thisServerPort = thisServerPort;
        this.loadBalancePort = Integer.parseInt(configReader.loadParamFromConfig("LOADBALANCE_PORT_FOR_SERVERS"));
        this.loadBalanceIP = configReader.loadParamFromConfig("LOADBALANCE_IP");

    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress loadBalanceServerIP = InetAddress.getByName(loadBalanceIP);
            while (true) {
                dataSend(socket, loadBalanceServerIP, serverLoad + "_" + thisServerPort);
                Thread.sleep(500);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void dataSend(DatagramSocket socket, InetAddress loadBalanceServerIP, String line) throws IOException {

        byte[] dataOut = line.getBytes();
        DatagramPacket packetOut = new DatagramPacket(
                dataOut,
                dataOut.length,
                loadBalanceServerIP,
                loadBalancePort
        );
        socket.send(packetOut);
    }
}
