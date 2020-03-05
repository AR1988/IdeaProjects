package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        // простые числа 11, 13, 17, 19, 23, 29, 31
        List<Integer> simpleNumbers = Arrays.asList(11, 13, 17, 19, 23, 29, 31);
        for (Integer num : simpleNumbers)
            System.out.println(isSimple(num));
        System.out.println();
        for (Integer num : simpleNumbers) {
            num++;
            System.out.println(isSimple(num));
        }
        IntStream s1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        IntStream s2 = IntStream.of(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);

        System.out.println(anyStream(s1, s2).toString());

        System.out.println(factorial(7));
        //2,3,4,5,6,7,8 2+4+6+8
        System.out.println(sum(2, 8));
    }

    static boolean isSimple(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
//                .anyMatch(n -> number % n != 0);
                .noneMatch(n -> number % n == 0);
    }

    static List<Integer> anyStream(IntStream s1, IntStream s2) {
        return IntStream.concat(s1, s2)
                .sorted()
                .skip(2)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    static long factorial(int n) {
        return LongStream
                .rangeClosed(1, n)
                .reduce((a, b) -> a * b)
                .orElse(0);
    }


    static int sum(int a, int b) {
        return IntStream
                .rangeClosed(a, b)
                .filter(res -> res % 2 == 0)
//                .reduce((x, y) -> x + y)
                .reduce(Integer::sum)
                .getAsInt();
    }
}
