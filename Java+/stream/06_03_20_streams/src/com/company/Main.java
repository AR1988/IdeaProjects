package com.company;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> streams = Stream.of("papa", "mama", "abba", "naan", "world");

        System.out.println(palindromeGroups(streams).toString());
    }

    static int multip(Stream<Integer> intStream) {
//        return intStream.map(number -> number * number).reduce(0, (number, number2) -> number * number2);
        return intStream.collect(Collectors.reducing(0, number -> number * number, (number, number2) -> number * number2));
    }

    static Map<Boolean, List<String>> palindromeGroups(Stream<String> stringStream) {
        return stringStream
                .collect(Collectors.partitioningBy(s -> (new StringBuilder(s).reverse()).toString().equals(s)));
    }
}