package com.company;

import java.util.*;

public class SearchSum {
    List<Integer> newList;
    int number;

    public SearchSum(List<Integer> list, int number) {
        Collections.sort(list);

        this.newList=list;
        this.number = number;
    }

    public boolean isSum() {
        Deque<Integer> newList2 = new ArrayDeque<>(newList);

        if (newList2.size() < 1)
            return false;

        while (newList2.size() != 0) {
            if ((newList2.getFirst() + newList2.getLast()) < number)
            newList2.removeFirst();

            else if ((newList2.getFirst() + newList2.getLast()) > number)
                newList2.removeLast();
            else return true;
        }
        return false;
    }
}
