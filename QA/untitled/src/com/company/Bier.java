package com.company;

public class Bier {
    String brand;
    double v;

    public Bier(String brand, double v) {
        this.brand = brand;
        this.v = v;
    }

    public boolean contains() {
        return v >= 0.5;
    }
}
