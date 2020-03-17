package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        List<Account> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new Account("" + i, random.nextInt(100000), false));
            list.add(new Account("" + i, random.nextInt(100000), true));
        }


        Predicate<Account> predicateBalanceIsPositive = x -> x.getBalance() > 0;
        Predicate<Account> predicateIsPLocked = Account::isBlock;
        Predicate<Account> predicateBalanceIsMore10000 = x -> x.getBalance() > 10000;

        AccFilter accFilter = new AccFilter();

        System.out.println("old school");
        List<Account> newList = accFilter.filterOldSchool(list, predicateIsPLocked.and(predicateBalanceIsPositive));
        List<Account> newList2 = accFilter.filterOldSchool(list, predicateIsPLocked.negate().and(predicateBalanceIsMore10000));

        newList.forEach(account -> System.out.println(account.toString()));
        newList2.forEach(account -> System.out.println(account.toString()));

        newList.clear();
        newList2.clear();

        System.out.println("stream method");
        newList = accFilter.filterStream(list, predicateIsPLocked.and(predicateBalanceIsPositive));
        newList2 = accFilter.filterStream(list, predicateIsPLocked.negate().and(predicateBalanceIsMore10000));

        newList.forEach(account -> System.out.println(account.toString()));
        newList2.forEach(account -> System.out.println(account.toString()));

        System.out.println("TernaryPredicate a!=b!=c");
        ITerraryPredicate<Integer> apply = (a, b, c) -> {
            boolean ab = !a.equals(b);
            boolean ac = !a.equals(c);
            boolean bc = !b.equals(c);
            return ab && bc && ac;
        };

        System.out.println(apply.test(1, 1, 2));
        System.out.println(apply.test(1, 2, 3));
    }

    static <T> Predicate<T> disjunction(List<Predicate<T>> predicates) {
        Predicate<T> res = o -> false;
        for (Predicate<T> pred : predicates)
            res = res.or(pred);
        return res;
    }
}
