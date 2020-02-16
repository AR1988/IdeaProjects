package com.company;

import java.util.List;
import java.util.Random;

public class CreditProviders implements Runnable {
    String name;
    int minTime;
    int maxTime;
    int creditsNum;

    List<FinishInfo> winRate;

    Random rdm = new Random();

    public CreditProviders(String name, int minTime, int maxTime, int creditsNum, List<FinishInfo> winRate) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.creditsNum = creditsNum;
        this.winRate = winRate;
    }

    @Override
    public void run() {


        minTime = name.equals("Maria") ? (int) (minTime * 0.2) : minTime;
        maxTime = name.equals("Maria") ? (int) (maxTime * 0.2) : maxTime;

        int vasjaSpeedupMinTime = (int) (minTime * 0.5);
        int vasjaSpeedupMaxTime = (int) (maxTime * 0.5);

        for (int i = 1; i <= creditsNum; i++) {
            int vajaSpeetUP = rdm.nextInt(4);

            if (name.equals("Vasja") && vajaSpeetUP == 2 && i < 18) {
                for (int j = 0; j < 3; j++) {
                    i++;
                    try {
                        Thread.sleep(vasjaSpeedupMinTime + rdm.nextInt(vasjaSpeedupMaxTime - vasjaSpeedupMinTime));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(minTime + rdm.nextInt(maxTime - minTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        winRate.add(new FinishInfo(name, System.currentTimeMillis()));
    }
}
