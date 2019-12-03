package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = getArray(3);
        System.out.println(array[0] + " " + array[1] + " " + array[2]);
//  4


    }

    static int[] getArray(int lenght) {

        int[] arrayName = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            arrayName[i] = i * 2;
        }
        return arrayName;
    }
}
