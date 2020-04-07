package com.company.updService;

import com.company.ServerInfo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.PriorityQueue;

public class CheckServerStatus implements Runnable {
    private PriorityQueue<ServerInfo> source;
    //    Source source;
    private long updateTime;

    //TODO: Source -> source!!!
    public CheckServerStatus(PriorityQueue<ServerInfo> source, long updateTime) {
        this.source = source;
        this.updateTime = updateTime;
    }


//    public CheckServerStatus(Source source, long updateTime) {
//        this.source = source;
//        this.updateTime = updateTime;
//    }

    @Override
    public void run() {
        LocalTime timeNow = LocalTime.now();
//        System.out.println("\t" + source.size() + "\t udpate time: " + updateTime);
        source.removeIf(si -> (si.getLocalTime().until(timeNow, ChronoUnit.SECONDS)) > updateTime);
    }
}

