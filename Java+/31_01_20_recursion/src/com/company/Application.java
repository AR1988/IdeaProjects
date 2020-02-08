package com.company;

public class Application {

    public static void main(String[] args) {
        int n = 8;
        int k = 3;
        System.out.println(power(n, k));
    }

    static private int power(int n, int k) {
        if (k == 0)
            return 1;
        return n * power(n, k - 1);
    }

    static private int powerTwoWithoutMultiplication(int n) {
        if (n == 0)
            return 0;
        return powerTwoWithoutMultiplication(n - 1) + n + n - 1;
    }
}
