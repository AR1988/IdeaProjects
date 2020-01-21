package com.company;

abstract public class Shape {
    char symvbol;

    public Shape(char symvbol) {
        this.symvbol = symvbol;
    }

    public char getSymvbol() {
        return symvbol;
    }

    abstract void draw();
}
