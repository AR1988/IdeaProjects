package com.company;

public class Application {

    public static void main(String[] args) {
        // write your code here

        Shape line = new Line('#', 10);
        Shape rectange = new Rectange('*', 10, 10);
        Shape triangle = new Triangle(' ', '/', '\\', 45);

//        Picture shapes = new Picture(new Shape[]{line, rectange});

//        line.draw();
//        rectange.draw();

    }
}
