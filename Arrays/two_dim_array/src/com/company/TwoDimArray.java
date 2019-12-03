package com.company;

public class TwoDimArray {

    public static void main(String[] args) {
// Arrays
        int myArray1[][] = {{1, -2, 3, -4, 5}, {6, -7, 8, 9, -10}, {1, 2, 3, 4, 5}, {1, -2, 3, -4, 5}, {6, -7, 8, 9, -10}, {1, 2, 3, 4, 5}, {1, -2, 3, -4, 5}, {6, -7, 8, 9, -10}, {1, 2, 3, 4, 5}};
        int myArray2[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int myArray3[][] = {{1, -2, 3, -4, 5}, {6, 7, 8, 9, 10}};
        int myArray4[][] = {{1, 2, 3, 4, 5}, {6, -7, 8, 9, -10}};

// Has Array negative numbers
        System.out.println(HasArrayNegativeNumbers(myArray1)); //true
        System.out.println(HasArrayNegativeNumbers(myArray2)); //false
        System.out.println(HasArrayNegativeNumbers(myArray3)); //true
        System.out.println(HasArrayNegativeNumbers(myArray4));// true

        System.out.println(Task2(myArray1));
    }

    //FUNCTION: Has Array negative numbers
    static boolean HasArrayNegativeNumbers(int[][] myCheckArray) {
        for (int i = 0; i < myCheckArray.length; i++) {
            for (int j = 0; j < myCheckArray.length; j++) {
                if (myCheckArray[i][j] < 0)
                    return true;
            }
        }
        return false;
    }

    static int Task2(int[][] myCheckArray1) {
        int result = 0;

        for (int i = 0; i < myCheckArray1.length; i++) {
            for (int j = 0; j < myCheckArray1.length; j++) {
                if (myCheckArray1[i][j] < 0) {
                    result++;

                }
            }
        }
        return result;
    }
}