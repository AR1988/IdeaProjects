package com.company;

public class IncrementingThread extends Thread {

    int iterationsNumber;
    Incrementer incrementer;

    public IncrementingThread(int iterationsNumber, Incrementer incremnter) {
        this.iterationsNumber = iterationsNumber;
        this.incrementer = incremnter;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterationsNumber; i++) {
            incrementer.increment();
        }
    }
}
