package com.company.updService;

import com.company.configServices.ConfigReader;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerLoad implements Runnable {

    //    private final static int SERVER_PORT = 2014; //порт куда кидать сообщение
//    private final static String SERVER_HOST = "localhost"; // адрес куда кида кидать сообщение
    private AtomicInteger serverLoad;
    private int thisServerPort;
    int loadBalancerPort;
    String loadBalancerIP;

    public ServerLoad(AtomicInteger serverLoad, int thisServerPort, ConfigReader configReader) throws IOException {
        this.serverLoad = serverLoad;
        this.thisServerPort = thisServerPort;
        this.loadBalancerPort = Integer.parseInt(configReader.loadParamFromConfig("LOADBALANCER_PORT_FOR_SERVERS"));
        this.loadBalancerIP = configReader.loadParamFromConfig("LOADBALANCER_IP_FOR_SERVERS");

    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getByName(loadBalancerIP);
            while (true) {
                dataSend(socket, serverIP, serverLoad + "_" + thisServerPort);
                Thread.sleep(1000);
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
                loadBalancerPort
        );
        socket.send(packetOut);
    }
}
