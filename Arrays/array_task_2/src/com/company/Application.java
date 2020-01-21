package com.company;

public class Application {

    public static void main(String[] args) {
        int[] myCheckArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] myCheckArray2 = {0, 10, 80, 6, 8};

        System.out.println("\n#### 1 ####");
        System.out.println("Масив содержит не четные числа " + check(myCheckArray1));
        System.out.println("Масив содержит не четные числа " + check(myCheckArray2));

        System.out.println("\n#### 2 ####");
        System.out.println("addition of even numbers 1: " + additionEvenNumbers(myCheckArray1));
        System.out.println("addition of even numbers 2: " + additionEvenNumbers(myCheckArray2));

        System.out.println("\n#### 3 ####");
        multiplyingEvenNumbersBy3(myCheckArray1);
        multiplyingEvenNumbersBy3(myCheckArray2);

        System.out.println("\n#### 4 ####");
        int arrayLength = 11;                   // длина масива для 4 задачи (фибоначи)
        int[] fibArray = new int[arrayLength];  // массив для 4 и 5 задания

        int n = 20;
        fib(fibArray, arrayLength);             // вызов функции для 4 задания

        System.out.println("\n#### 5 ####");
        int searchNumber = 55;                  // искомое число для 5 задания
        System.out.println("Search Number is : " + searchNumber + "\nNumber found? : " + hasCurrentNumber(fibArray, searchNumber));     // вызов функции для 5 задания
        System.out.println("\n#### 6 ####");
        int[] arrayTask6 = new int[]{2, 20, 2, 3, 5};
        System.out.println(sum(arrayTask6, n));
        System.out.println();
    }

    //1 Tasks
    private static boolean check(int[] myArray) {
//        boolean myArrayBoolean = false;
//        for (int i = 0; i < myArray.length; i++) {
//            if (myArray[i] % 2 != 0) {
//                myArrayBoolean = true;
//                break;
//            } else myArrayBoolean = false;
//        }
//        return myArrayBoolean;

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 != 0)
                return true;
        }
        return false;
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
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 == 0)
                myArray[i] = myArray[i] * 3;
            System.out.println("multiplying the even numbers of the array by 3, result: " + myArray[i]);
        }
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
            if (arrayTask6[i] % 2 == 0 && arrayTask6[i] < numberN) {
                sum += arrayTask6[i];
            }
        }
        return sum;
    }

    // task 7
    // написать ф-ю которая принимает массив и искомый эллемнт и возвращает либо индекс, в случае успеха, либо индекс, куда можно вставить этот элемент с отрицательным знаком.
    private static int searchIndex(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                return i;
            else (array[i] < number )
        }
    }
}

