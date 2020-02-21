package com.company;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Set<Integer> sou = getset1();
        Set<Integer> sou2 = getset2();
        System.out.println("addAll " + sou.addAll(sou2));
        System.out.println("getset1 ");
        for (Integer integer : sou)
            System.out.print(integer + " ");

        System.out.println();
        sou = getset1();
        sou2 = getset2();

        System.out.println("retainAll " + sou.retainAll(sou2));
        System.out.println("getset1 ");
        for (Integer integer : sou)
            System.out.print(integer + " ");

        System.out.println();
        sou = getset1();
        sou2 = getset2();

        System.out.println("removeAll" + sou.removeAll(sou2));
        System.out.println("getset1 ");
        for (Integer integer : sou)
            System.out.print(integer + " ");
    }

    public static Set<Integer> getset1() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        return set;
    }

    public static Set<Integer> getset2() {
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(10);
        set.add(11);
        return set;
    }
}
