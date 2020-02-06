package com.company;

import java.util.*;

public class SearchSum {
    Deque<Integer> newList;

    public SearchSum(List<Integer> list) {
        Collections.sort(list);
        this.newList = new ArrayDeque<>(list);
    }

    public boolean isSum(int number) {
        if (newList.size() < 1)
            return false;

        while (newList.size() != 0) {
            if ((newList.getFirst() + newList.getLast()) < number)
                newList.removeFirst();

            else if ((newList.getFirst() + newList.getLast()) > number)
                newList.removeLast();
            else return true;
        }
        return false;
    }
}
