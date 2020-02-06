package com.company;

public class Application {

    public static void main(String[] args) {
        int n = 8;
        int k = 3;
        System.out.println(power(n, k));
    }

    static private int power(int n, int k) {
        if (k < 2)
            return 1;
        return n * power(n, k - 1);
    }
}
