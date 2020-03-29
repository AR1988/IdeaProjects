package com.company;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> {
            int res = x;
            if (x > y)
                return null;
            else {
                for (int i = x; i < y; i++) {
                    res *= x++;
                }
            }
            return res;
        };
        System.out.println(biFunction.apply(5, 10));
    }
}
