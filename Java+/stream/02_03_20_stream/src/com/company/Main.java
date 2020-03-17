package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> strings =
                Arrays.asList("Hello", " Telran", " Group"
                        , " NUMBER", "NINE", " MY ", "Name"
                        , " IS", " Vaja", " or");
        List<String> strings1 =
                Arrays.asList("Hello", " my ", " name ", " is", "Andrej.", "Hello, ", " my ", " name ", " is", "Andrej.");

        System.out.println(concatFromLongString(strings, 5));
        concatFromLongList(strings, 5).forEach(System.out::println);

        System.out.println(task2(strings, 4));
        System.out.println(concatFromListToUppercase(strings1));
    }

    static String concatFromLongString(Collection<String> strings, int n) {
        System.out.println("Есть лист строк.  составить из них одну большую строку. состоящию из строк длинной больше " + n + " в нихнем регистре");
        return strings.stream()
                .filter(s -> s.toCharArray().length > n)
                .map(String::toLowerCase)
                .collect(Collectors.joining());
    }

    static List<String> concatFromLongList(Collection<String> strings, int n) {
        return strings.stream()
                .filter(s -> s.length() > n)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    static long task2(List<String> strings, int n) {
        System.out.println("Есть лист строк, вернут лист строк, длина которых меньше " + n);
        return strings.stream()
                .filter(s -> s.length() < 4)
                .count();
    }

    static String concatFromListToUppercase(Collection<String> strings) {
        System.out.println("Есть лист строк. Составить одну сторку из листаб длиной больше 5, ToUpperCase, исключить повторения");
        return strings.stream().filter(s -> s.length() > 5)
                .map(String::toUpperCase)
                .distinct()
//                .reduce((currentRes, currentElt) -> currentRes + currentElt)
//                .reduce((currentRes, currentElt) -> currentRes.concat(currentElt))
                .reduce(String::concat)
                .orElse("");
    }
}
