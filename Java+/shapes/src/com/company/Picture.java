package com.company;

public class Picture extends Shape {


    private Shape[] scapes;


    public Picture(char symvbol, Shape[] scapes) {
        super(symvbol);
        this.scapes = scapes;
    }

    @Override
    void draw() {

    }

}
