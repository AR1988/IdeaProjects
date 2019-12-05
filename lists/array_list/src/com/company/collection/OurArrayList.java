package com.company.collection;

import com.company.CountryCode;
import com.company.comparator.AbstractComparator;
import com.company.comparator.CountryCodeComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OurArrayList {

    private Object[] source;
    private static final int INITIAL_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(Object value) {
        if (source.length == size) {
            Object[] newSource = new Object[source.length * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = value;
        size++;
    }

    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return source[index];
    }

    public void set(int index, Object value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }

    public boolean remove(Object value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(value)) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Object result = source[index];

        System.arraycopy(source, index + 1, source, index, source.length - (index + 1));
        size--;
        return result;
    }

    public Object max(AbstractComparator comparator) {
        if (source.length == 0)
            throw new EmptyListException();

        Object max = source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(source[i], max) > 0)
                max = source[i];
        }

        return max;
    }


    public Object min(AbstractComparator comparator) {

//        AbstractComparator invertedComparator = new AbstractComparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return -comparator.compare(o1, o2);
//            }
//        };
//
//        return max(invertedComparator);

        if (source.length == 0)
            throw new EmptyListException();

        Object min = source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(source[i], min) < 0)
                min = source[i];
        }

        return min;
    }

    public void sort(AbstractComparator comparator) {

        for (int i = 0; i < size; i++) {
            Object min = source[i];
            int minId = i;

            for (int j = i; j < size; j++) {
                if (comparator.compare(source[j], min) < 0) {
                    min = source[j];
                    minId = j;
                }
            }

            Object temp = source[minId];
            source[minId] = source[i];
            source[i] = temp;
        }
    }
}
