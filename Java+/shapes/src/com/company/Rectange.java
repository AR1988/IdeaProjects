package com.company;

public class Rectange extends Shape {
    int wight;
    int height;

    public Rectange(char symvbol, int wight, int height) {
        super(symvbol);
        this.wight = wight;
        this.height = height;
    }

    @Override
    void draw() {
        for (int i = 0; i < wight; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(symvbol);
            }
            System.out.println();
        }
        System.out.println();
    }
}
