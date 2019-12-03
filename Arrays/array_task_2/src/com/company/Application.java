package com.company;

public class Application {

    public static void main(String[] args) {
        int[] myCheckArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] myCheckArray2 = {0, 10, 77, 3, 5};

        System.out.println("\n#### 1 ####");
        System.out.println("Масив содержит не четные числа " + check(myCheckArray1));
        System.out.println("Масив содержит не четные числа " + check(myCheckArray2));

        System.out.println("\n#### 2 ####");
        System.out.println("addition of even numbers 1: " + additionEvenNumbers(myCheckArray1));
        System.out.println("addition of even numbers 2: " + additionEvenNumbers(myCheckArray2));

        System.out.println("\n#### 3 ####");
        multiplyingEvenNumbersBy3(myCheckArray1);
        multiplyingEvenNumbersBy3(myCheckArray2);
    }
//1 Tasks
    private static boolean check(int[] myArray) {
        boolean myArrayBoolean = false;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 != 0) {
                myArrayBoolean = true;
                break;
            } else myArrayBoolean = false;
        }
        return myArrayBoolean;
    }
//2 Tasks
    private static int additionEvenNumbers(int[] myArray) {
        int result = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 != 0) {
                result += myArray[i];
            }
        }
        return result;
    }
//3 Tasks
    private static void multiplyingEvenNumbersBy3(int[] myArray) {
        int result1 = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 == 0)
                myArray[i] = myArray[i] * 3;
            System.out.println("multiplying the even numbers of the array by 3, result: " + myArray[i]);
        }
        System.out.println();
    }
}

