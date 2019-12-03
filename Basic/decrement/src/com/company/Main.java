package com.company;

public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        a++;       // мы как бы перезаписали значение переменой "a" на +1. А

        int summ = a + b;

        System.out.println("int a++ =" + a); // т.к. a++ то стало 11
        System.out.println("int b-- =" + b); // 10
        System.out.println("int a + c = " + summ);

    }
}
