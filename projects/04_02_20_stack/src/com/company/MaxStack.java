package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;

public class MaxStack<E> {

    Deque<E> source = new ArrayDeque<>();
    Deque<E> maxSource = new ArrayDeque<>();

    Comparator<E> comparator;

    public MaxStack(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public MaxStack() {
//        this.comparator = new Comparator<E>() {
//            @Override
//            public int compare(E o1, E o2) {
//                Comparable<E> newO1 = (Comparable) o1;
//                return newO1.compareTo(o2);
//            }
//        };

        this.comparator = (E o1,E o2) -> {
            Comparable<E> newO1 = (Comparable) o1;
            return newO1.compareTo(o2);
        };
    }

    public void addLast(E elt) {
        source.addLast(elt);
        if (size() == 0 || comparator.compare(elt,max()) > 0)
            maxSource.addLast(elt);
        else
            maxSource.addLast(max());
    }

    public E getLast() {
        return source.getLast();
    }

    public int size() {
        return source.size();
    }

    public E removeLast() {
        maxSource.removeLast();
        return source.removeLast();
    }

    public E max() {
        return maxSource.getLast();
    }
}
