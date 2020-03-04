package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Incrementer ic = new Incrementer();
        Thread th = new IncrementingThread(1000, new Incrementer());

        for (int i = 0; i < 10000; i++) {
            th.run();
        }
        System.out.println(ic.getCounter());

    }
}
