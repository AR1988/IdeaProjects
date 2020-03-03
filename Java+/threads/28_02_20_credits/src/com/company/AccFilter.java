package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AccFilter {

    public List<Account> filterOldSchool(List<Account> list, Predicate<Account> predicate) {
        List<Account> newList = new ArrayList<>();

        for (Account acc : list) {
            if (predicate.test(acc))
                newList.add(acc);
        }
        return newList;
    }

    public List<Account> filterStream(List<Account> list, Predicate<Account> predicate) {
        List<Account> newList = new ArrayList<>();
//        list.stream().filter(predicate).forEach(acc -> newList.add(acc));
        list.stream().filter(predicate).forEach(e -> newList.add(e));
        return newList;
    }
}