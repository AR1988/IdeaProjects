package com.company;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CheckServersStatus implements Runnable {
    //    PriorityQueue<ServerInfo> source;
    ConcurrentLinkedQueue<ServerInfo> source;

    public CheckServersStatus(ConcurrentLinkedQueue<ServerInfo> source) {
        this.source = source;
    }

    @Override
    public void run() {
        while (true) {
            LocalTime timeNow = LocalTime.now();
            source.stream()
                    .filter(si -> (si.getLocalTime().until(timeNow, ChronoUnit.SECONDS)) > 4)
                    .forEachOrdered(si -> source.remove(si));
        }
    }
}
