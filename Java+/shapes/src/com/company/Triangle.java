package com.company;

public class Triangle extends Shape {

    char lefttPoints;
    char rightPoints;
    int length;

    public Triangle(char symvbol, char lefttPoints, char rightPoints, int length) {
        super(symvbol);
        this.lefttPoints = lefttPoints;
        this.rightPoints = rightPoints;
        this.length = length;
    }

    @Override
    void draw() {

        if (length % 2 == 1) {

            int high = (length + 1) / 2;
            int top = length / 2; //5

            int nextPointRight = 0;
            int nextPointLeft = 0;


            for (int i = 0; i < length; i++) {
                if (top == i) {
                    System.out.print("^");
                    continue;
                }
                System.out.print(" ");
            }

            System.out.println();

            for (int j = 1; j < high; j++) {
                for (int i = 0; i < length; i++) {

                    nextPointLeft = top - j;
                    nextPointRight = top + j;

                    if (nextPointLeft == i) {
                        System.out.print(lefttPoints);
                        continue;
                    }
                    if (nextPointRight == i) {
                        System.out.print(rightPoints);
                        continue;
                    }

                    System.out.print(symvbol);
                }
                System.out.println();
            }
            for (int i = 0; i < length + 1; i++) {
                System.out.print("‾");
            }
        }
        else
            System.out.println("не верно указанны параметры! Введите НЕ ЧЕТНОЕ значение");
    }
}
