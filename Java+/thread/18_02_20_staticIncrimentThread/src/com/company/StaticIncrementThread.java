package com.company;

public class StaticIncrementThread extends Thread {
    private static int counter;
    private int number;
    final Object mu;


    public StaticIncrementThread(int number, Object mu) {
        this.number = number;
        this.mu = mu;
    }

    private void increment() {
        synchronized (mu) {
            counter++;
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            increment();
        }
    }

    public static int getCounter() {
        return counter;
    }
}
