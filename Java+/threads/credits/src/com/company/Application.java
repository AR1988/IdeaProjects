package com.company;

import java.util.*;

public class Application {
    private static final int CREDITS_NUM = 20;
    private static final int MIN_TIME = 70;
    private static final int MAX_TIME = 100;
    private static final int CREDIT_PROVIDER = 3;


    public static void main(String[] args) throws InterruptedException {
        // write your code here
//Есть Петя,Вася, Маша. Они выдают кредиты.
//Скорость выдачи от maxTime для Васи и Пети. У маши скорость 1.2 minTime до 1.2 maxTime.
//Вася иногда меняет скорость выдачи, тогда он выдает со скоростью 1.5 (minTime, maxTime) 3 кредита подряд. С вероятность ускорения 20%.
//Кто вперед выдаст m кредитов?
        List<FinishInfo> winRate = new ArrayList<>();
        String[] name = {"Maria", "Vasja", "Petr"};


        List<Thread> threads = createThreads(winRate, name);
        long startTime = System.currentTimeMillis();

        startThreads(threads);
        joinThreads(threads);

        int i = 1;
        for (FinishInfo info : winRate)
            System.out.println("Credit Provider \"" + info.name + " at plase \"" + i++ + "\" With result: " + (info.finishTime - startTime) + " ms.");

    }

    private static void joinThreads(List<Thread> threads) throws InterruptedException {
        for (Thread th : threads) {
            th.join();
        }
    }

    private static void startThreads(List<Thread> threads) {
        for (Thread th : threads) {
            th.start();
        }
    }

    private static List<Thread> createThreads(List<FinishInfo> winRate, String[] name) {
        List<Thread> res = new ArrayList<>();
        for (int i = 0; i < CREDIT_PROVIDER; i++) {
            CreditProviders providers = new CreditProviders(name[i], MIN_TIME, MAX_TIME, CREDITS_NUM, winRate);
            res.add(new Thread(providers));
        }
        return res;
    }
}
