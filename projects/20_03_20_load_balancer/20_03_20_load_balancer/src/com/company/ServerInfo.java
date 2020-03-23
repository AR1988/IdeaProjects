package com.company;

import java.net.InetAddress;

public class ServerInfo {
    private InetAddress IP;
    private int serverPort;

    public ServerInfo(InetAddress IP, int serverPort) {
        this.IP = IP;
        this.serverPort = serverPort;
    }

    @Override
    public String toString() {
        return IP + "_" + serverPort;
    }
}
