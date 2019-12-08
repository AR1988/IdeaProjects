package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Tasks1 {

    public static void main(String[] args) {
        // 1. Как найти средний элемент в LinkedList за один проход?
        System.out.println("TASK 1");
        System.out.println("Return middle obj in LinkedList. It is size/2;\nMiddle obj =  \t" + task1(10));

        //2. Как найти в LinkedList i-тый элемент с конца за один проход?
        System.out.println("TASK 2");
        System.out.println("Find i Element from end. get.size - i ;\ni obj =  \t" + task2(3, 10));

        //3.Как определить дублированный элемент в массиве, в котором содержатся элементы типа int от 1 до 100, при условии, что в массиве дублируется только один элемент?
        System.out.println("TASK 3");
        System.out.println("Find duplicated number in array 1..100. Summ array1(non duplicated) - summ array2(with duplicated)\nduplicated number = \t" + task3(153));

        //4 Как найти продублированные элементы в массиве, если их больше одного?
        System.out.println("TASK 4");
        task4(11);

        //5 В чём разница между двусвязным и односвязным списком?
        System.out.println("TASK 5");
        System.out.println("В чём разница между двусвязным и односвязным списком?");
        System.out.println("Оба списка позволяют перемещаться от узла к узлу, но");
        System.out.println("в односвязном списке возможно перемещение только в одну сторону. От 1 к 2, от 2 к 3...");
        System.out.println("в двусвязном списке возможен переход как и в односвязном, а так же и в обратную сторону. от 4 к 3, от 3 к 2.... Т.е. перемещаться в двух направлениях.");

        //6 Напишите программу для вывода чисел Фибоначчи
        System.out.println("TASK 6");
        System.out.println("Fib " + fib(10));
    }

    static LinkedList list(int size) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < size + 1; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }


    static Object task1(int size) {
        return list(size).get(list(size).size() / 2);
    }

    static Object task2(int index, int size ) {
        return list(size).get(list(size).size() - index);
    }

    static int task3(int duplicated) {
        int[] array = new int[100];
        int[] array2 = new int[101];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            array2[i] = i;
        }
        int result = 0;
        int result2 = 0;

        for (int i = 0; i < array.length; i++) {
            result += array[i];
            result2 += array2[i];
        }
        array2[100] = duplicated;
        result2 += array2[100];

        return result2 - result;
    }

    static void task4(int numberOfduplicatedElements) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < numberOfduplicatedElements + 1; i++) {
            array[i] = 100;
        }

        Arrays.sort(array);

        int result = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                result++;
            }
        }
        System.out.println("Duplicated elements: \t" + result);
    }

    static int fib(int fibLength) {

        int[] fibArray = new int[fibLength + 1];
        for (int i = 0; i < fibArray.length; i++) {
            fibArray[i] = i;
        }
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 2] + fibArray[i - 1];
        }
        return fibArray[fibLength];
    }
}
