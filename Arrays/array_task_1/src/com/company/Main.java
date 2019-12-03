package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int arrayLength = 11;                   // длина масива для 4 задачи
        int[] fibArray = new int[arrayLength];  // массив для 4 и 5 задания
        int searchNumber = 55;                  // искомое число для 5 задания
        int n = 20;

        int[] arrayTask6 = new int[] {2,20,2,3,5};

        fib(fibArray, arrayLength);             // вызов функции для 4 задания
        System.out.println();

        System.out.println("Search Number is : " + searchNumber + "\nHas number found? : " + hasCurrentNumber(fibArray, searchNumber));     // вызов функции для 5 задания
        System.out.println();

        System.out.println(sum(arrayTask6, n));
        System.out.println();
    }

    // task 4
    private static void fib(int[] number, int arrayLength) {
        number[1] = 1;

        System.out.println("stage = " + 0 + "\tresult = " + number[0]);
        System.out.println("stage = " + 1 + "\tresult = " + number[1]);

        for (int i = 2; i < arrayLength; i++) {
            number[i] = number[i - 1] + number[i - 2];
            System.out.println("stage = " + i + "\tresult = " + number[i]);
        }
    }

    // task 5
    private static boolean hasCurrentNumber(int[] arrayForCheck, int number) {
        boolean checkResult = false;
        for (int i = 0; i < arrayForCheck.length; i++) {
            if (arrayForCheck[i] == number)
                checkResult = true;
        }
        return checkResult;
    }

    // task 6
    // Написать функцию, которая принимает int массив и int число N, которая считает сумму всех четных чисел из массива, не превышающих N, и отдает ее. (edited)
    private static int sum(int[] arrayTask6, int numberN) {
        int sum = 0;
        for (int i = 0; i < arrayTask6.length; i++) {
            if (arrayTask6[i] % 2 == 0 && arrayTask6[i] < numberN ) {
                sum += arrayTask6[i];
            }
        }
        return sum;
    }
}


