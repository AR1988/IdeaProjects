package com.company;

public class Line extends Shape {
    int lenght;

    public Line(char symbol, int lenght) {
        super(symbol);
        this.lenght = lenght;
    }

    @Override
    void draw() {
        for (int i = 0; i < lenght ; i++) {
            System.out.print(getSymvbol());
        }
        System.out.println();
    }
}
