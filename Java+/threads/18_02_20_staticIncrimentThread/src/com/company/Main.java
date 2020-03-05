package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int increment = 10 * 1000;
        int threadsNum = 10 * 100;

        Object obj = new Object();

        Thread[] threads = new Thread[threadsNum];

        for (int i = 0; i < threadsNum; i++) {
            threads[i] = new StaticIncrementThread(increment, obj);
        }
        for (int i = 0; i < threadsNum; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadsNum; i++) {
            threads[i].join();
        }
        System.out.println(StaticIncrementThread.getCounter());
    }
}
