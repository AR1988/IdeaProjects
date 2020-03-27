package com.company;

import java.util.PriorityQueue;

public class Source extends PriorityQueue<ServerInfo> {
    PriorityQueue<ServerInfo> source;

    public Source(PriorityQueue<ServerInfo> source) {
        this.source = source;
    }

    @Override
    public boolean add(ServerInfo serverInfo) {
        source.removeIf(si -> si.toString().equals(serverInfo.toString()));
        return source.add(serverInfo);
    }

    @Override
    public String toString() {
        return "Source{" +
                "source=" + source +
                '}';
    }

    @Override
    public ServerInfo peek() {
        return source.peek();
    }

    @Override
    public int size() {
        return source.size();
    }
}
