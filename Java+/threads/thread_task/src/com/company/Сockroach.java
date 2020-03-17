package com.company;

import java.util.List;
import java.util.Random;

public class Сockroach implements Runnable {
    int id;
    int minTime;
    int maxTime;
    int nSteps;
    List<FinishInfo> winRate;

    public Сockroach(int id, int minTime, int maxTime, int nSteps, List<FinishInfo> winRate) {
        this.id = id;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.nSteps = nSteps;
        this.winRate = winRate;
    }


    @Override
    public void run() {
        Random rdm = new Random();
        int speed = minTime + rdm.nextInt(maxTime - minTime);
        System.out.println("start id: " + id);

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < nSteps; i++) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
            }
        }
        winRate.add(new FinishInfo(id, System.currentTimeMillis()));
    }
}
