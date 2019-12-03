package com.company;

public class variables2 {

    public static void main(String[] args) {

        // A programm of the total amount of Anna's and Peter's apples

                double annaApples = 2.5;
                double peterApples = 3.333;

                double totalApples = annaApples + peterApples;

        System.out.println(totalApples);

        float floatNum1 = 0.3f;
        float floatNum2 = 0.3f;
        float floatSum = floatNum1 + floatNum2;

        float floatNum3 = 1.9f;
        double doubleNum1 = 1.2;

        // FloatNum3 >> double

        double doubleNum2 = floatNum3 + doubleNum1;
        //impossible!
        //float test = floatNum3 + doubleNum1;
        //float test = doubleNum1;
        //possible!
        //down casting
        //float test = floatNum3 + (float)doubleNum1;
        //float test = (float)doubleNum1;
        //double/double
        System.out.println("double/double " + 9.5 / 3.5);
        //float/float
        System.out.println("float/float " + 9.5f / 3.5f);
        //double/float
        System.out.println("double/float " + 9.5 / 3.5f);
        //float/int
        System.out.println("float/int " + 9.0 / 3);

    }
}
