package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        List<FinishInfo> winRate = new ArrayList<>();

        int minTime = 100;
        int maxTime = 150;
        int steps = 20;

        Сockroach id1 = new Сockroach(1, minTime, maxTime, steps, );
        Сockroach id2 = new Сockroach(2, minTime, maxTime, steps, winRate);
        Сockroach id3 = new Сockroach(3, minTime, maxTime, steps, winRate);
        Сockroach id4 = new Сockroach(4, minTime, maxTime, steps, winRate);
        Сockroach id5 = new Сockroach(5, minTime, maxTime, steps, winRate);
        Сockroach id6 = new Сockroach(6, minTime, maxTime, steps, winRate);
        Сockroach id7 = new Сockroach(7, minTime, maxTime, steps, winRate);
        Сockroach id8 = new Сockroach(8, minTime, maxTime, steps, winRate);
        Сockroach id9 = new Сockroach(9, minTime, maxTime, steps, winRate);
        Сockroach id10 = new Сockroach(10, minTime, maxTime, steps, winRate);


        Thread th1 = new Thread(id1);
        Thread th2 = new Thread(id2);
        Thread th3 = new Thread(id3);
        Thread th4 = new Thread(id4);
        Thread th5 = new Thread(id5);
        Thread th6 = new Thread(id6);
        Thread th7 = new Thread(id7);
        Thread th8 = new Thread(id8);
        Thread th9 = new Thread(id9);
        Thread th10 = new Thread(id10);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();
        th9.start();
        th10.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();
        th6.join();
        th7.join();
        th8.join();
        th9.join();
        th10.join();


        System.out.println("FINISH");
    }
}
