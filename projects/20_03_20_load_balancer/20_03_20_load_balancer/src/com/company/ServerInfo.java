package com.company;

import java.net.InetAddress;

public class ServerInfo {
    private InetAddress IP;
    private int serverPort;
    private int serverLoad;


    public ServerInfo(InetAddress IP, int serverPort, int serverLoad) {
        this.IP = IP;
        this.serverPort = serverPort;
        this.serverLoad = serverLoad;
    }

    public InetAddress getIP() {
        return IP;
    }

    public int getServerPort() {
        return serverPort;
    }
}
