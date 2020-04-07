package com.company;

import java.net.InetAddress;
import java.time.LocalTime;
import java.util.Objects;

public class ServerInfo implements Comparable<ServerInfo> {
    private InetAddress serverIP;
    private int serverPort;
    private int serverLoad;
    private LocalTime localTime = LocalTime.now();

    public ServerInfo(InetAddress serverIP, int serverPort, int serverLoad) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.serverLoad = serverLoad;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    @Override
    public int compareTo(ServerInfo o) {
        return Integer.compare(this.serverLoad, o.serverLoad);
    }

    @Override
    public String toString() {
        return serverIP + "_" + serverPort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverIP, serverPort);
    }
}
