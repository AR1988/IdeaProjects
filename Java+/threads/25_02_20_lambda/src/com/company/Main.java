package com.company;

import jdk.dynalink.Operation;

import javax.naming.directory.Attribute;
import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        OldSchool oldSchool = new OldSchool();
        System.out.println("old school: " + oldSchool.apply(10));

        Function<Integer, Integer> function = x -> x * 2;
        System.out.println("modern: " + function.apply(9));

        System.out.println("______\"::\" метод референс:______");
        Function<String, String> identical = String::new;
        System.out.println(identical.apply("\"String\" hello"));

        Function<Double, Double> sqrt = Math::sqrt;
        System.out.println(sqrt.apply((double) 10));

        BiFunction<Integer, Integer, Integer> multi = (a, b) -> {
            for (int i = a + 1; i <= b; i++) {
                a *= i;
            }
            return a;
        };

        System.out.println("Result bifurcation" + multi.apply(2, 8));

        List<Integer> collection = Arrays.asList(1, 5, 10, 8, 9, 0, 8, 1, 8, 1);
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer temp : collection) {
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            } else
                map.put(temp, 1);
        }
        for (Map.Entry<Integer, Integer> str : map.entrySet())
            System.out.println(str);
        System.out.println("______Lambda Function______");

        map.clear();

//        for (Integer i : collection)
//            map.put(i, 0);

        for (Integer num : collection)
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);

//        for (Map.Entry<Integer, Integer> str : map.entrySet())
//            System.out.println(str);

        map.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));

        //написать лямбдуб которая принимает лист строкб вощвращает лист неповторяющихня строк
        Function<List<String>, List<String>> listListFunction = (result) -> new ArrayList<>(new HashSet<>(result));
        List<String> source = Arrays.asList("a", "b", "c", "d", "e", "a", "b", "c", "d", "e");
        listListFunction.apply(source).forEach(System.out::print);
        //написать уравнение через лямбду вида: axx+bx+c, где a,b,c константы
        int a = 2;
        int b = 2;
        int c = 2;
        Function<Double, Double> doubleDoubleFunction = x -> a * x * x + b * x + c;
        System.out.println(doubleDoubleFunction.apply((double) 10));

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> dividedBy3 = x -> x % 3 == 0;
        Predicate<Integer> pred = isEven.negate().and(dividedBy3);
        System.out.println(pred.test(6));
    }
}

