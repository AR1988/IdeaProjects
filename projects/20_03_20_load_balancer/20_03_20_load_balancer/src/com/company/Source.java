package com.company;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.PriorityQueue;

public class Source implements Runnable {
    PriorityQueue<ServerInfo> source;

    public Source(PriorityQueue<ServerInfo> source) {
        this.source = source;
    }

    public void cheekActive() {
        LocalTime timeNow = LocalTime.now();
        source.stream()
                .filter(si -> (timeNow.until(si.getLocalTime(), ChronoUnit.SECONDS)) < 3)
                .forEachOrdered(si -> source.remove(si));
    }

    public void add(ServerInfo serverInfoToAdd) {
        source.add(serverInfoToAdd);
    }

    @Override
    public void run() {
        cheekActive();
    }
}
