package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(task4(8));
    }

    public static int task3(int summ) {
        int res = 0;
        int[] array = {10, 5, 1};

        for (int i = 0; i < array.length; i++) {
            while (summ >= array[i]) {
                summ -= array[i];
                res++;
            }
        }
        return res;
    }

    public static int task4(int number) {
        int result = 0;
        int temp = 0;
        for (int i = 1; i < number; i++) {
            temp += i;
            result++;
            if (temp + 1 + i > number) {
                return result;
            }
        }
        return 1;
    }
}


