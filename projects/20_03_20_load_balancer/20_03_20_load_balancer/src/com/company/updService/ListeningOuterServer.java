package com.company.updService;

import com.company.Source;
import com.company.configServices.ConfigReader;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListeningOuterServer implements Runnable {
    private Source source;
    private DatagramSocket socket;
    int threads;
    private int dataSize;


    public ListeningOuterServer(Source source, int port, int threads, int dataSize) throws SocketException {
        this.source = source;
        this.socket = new DatagramSocket(port);
        this.threads = threads;
        this.dataSize = dataSize;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        while (true) {
            try {
                byte[] dataToReceive = new byte[dataSize];
                DatagramPacket packetIn = new DatagramPacket(dataToReceive, dataSize);
                this.socket.receive(packetIn);

                SendServerToOuterServer task = new SendServerToOuterServer(source, socket, packetIn);

                executorService.execute(task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

class SendServerToOuterServer implements Runnable {
    private Source source;
    private DatagramSocket socket;
    private DatagramPacket packetIn;

    public SendServerToOuterServer(Source source, DatagramSocket socket, DatagramPacket packetIn) {
        this.source = source;
        this.socket = socket;
        this.packetIn = packetIn;
    }

    private static final String FILE_DIRECTORY = "C:/Users/andre/IdeaProjects/projects/20_03_20_load_balancer/config/config.props";
    private static final String SERVER_0_PORT = "SERVER_0_PORT";
    private static final String LOAD_BALANCE_IP = "LOADBALANCE_IP";

    @Override
    public void run() {
        try {
            //if no servers in source, then using reserve server on
            String address = source.size() != 0 ? source.peek().toString() : getReserveServer();
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

    private String getReserveServer() throws IOException {
        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);
        int portServer0 = Integer.parseInt(configReader.loadParamFromConfig(SERVER_0_PORT));
        String reserveServerIP = configReader.loadParamFromConfig(LOAD_BALANCE_IP);
        return "/" + reserveServerIP + "_" + portServer0;
    }
}

