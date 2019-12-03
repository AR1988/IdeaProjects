package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int [] array1 = {1,2,3,4,5,6,10};
        int [] array2 = {1,2,3,44,5,6,11};
        int arrayLenght = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j])
                    arrayLenght++;
            }
        }
        int[] newarray = new int[arrayLenght];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j])
                    newarray[index++] = array1[i];
            }
        }
        System.out.println(Arrays.toString(newarray));
    }
}
