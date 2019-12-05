package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        // write your code here
    }

    public static int nod(int x, int y) {

        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}


