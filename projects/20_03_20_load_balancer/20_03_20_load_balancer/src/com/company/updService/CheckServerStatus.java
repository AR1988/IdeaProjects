package com.company.updService;

import com.company.ServerInfo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.PriorityQueue;

public class CheckServerStatus implements Runnable {
    private PriorityQueue<ServerInfo> source;

    public CheckServerStatus(PriorityQueue<ServerInfo> source) {
        this.source = source;
    }

    @Override
    public void run() {
        LocalTime timeNow = LocalTime.now();
        source.removeIf(si -> (si.getLocalTime().until(timeNow, ChronoUnit.SECONDS)) > 15);
    }
}

