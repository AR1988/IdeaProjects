package com.company.collection;


import com.company.comparator.IntegerOurComparator;
import com.company.comparator.OurComparator;

import java.util.*;

public class OurStack<E> {
    private List<E> source;

    public OurStack() {
        source = new ArrayList<>();
    }

    public void addLast(E element) {
        source.add(element);
    }

    public E remove() {
        return source.remove(source.size() - 1);
    }

    public E getLast() {
        return source.get(source.size() - 1);
    }

    public Integer getMax() throws EmptyListException {
        if (source.size() == 0)
            throw new EmptyListException();
        OurComparator cp = new IntegerOurComparator();
        return (Integer) getMax(cp);
    }


    public E getMax(OurComparator cp) throws EmptyListException {
        if (source.size() == 0)
            throw new EmptyListException();

        E max = source.get(0);
        for (int i = 1; i < source.size(); i++) {
            if (cp.compare(source.get(i), max) > 0)
                max = source.get(i);
        }
        return max;
    }
}
