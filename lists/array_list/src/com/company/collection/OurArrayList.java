package com.company.collection;

import com.company.comparator.AbstractComparator;

import java.util.Objects;

public class OurArrayList<E> implements OurList<E> {

    private E[] source;
    private static final int INITIAL_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = (E[]) new Object[INITIAL_CAPACITY];
    }

    public int size() {
        return size;
    }


    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public void append(E value) {
        if (source.length == size) {
            E[] newSource = (E[]) new Object[source.length * 2];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size] = value;
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return source[index];
    }

    @Override
    public void set(int index, E value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;
    }

    @Override
    public boolean remove(E value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(value)) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        E result = source[index];

        System.arraycopy(source, index + 1, source, index, source.length - (index + 1));
        size--;
        return result;
    }

    public E max(AbstractComparator comparator) {
        if (source.length == 0)
            throw new EmptyListException();

        E max = source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(source[i], max) > 0)
                max = source[i];
        }

        return max;
    }


    public E min(AbstractComparator comparator) {

//        AbstractComparator invertedComparator = new AbstractComparator() {
//            @Override
//            public int compare(E o1, E o2) {
//                return -comparator.compare(o1, o2);
//            }
//        };
//
//        return max(invertedComparator);

        if (source.length == 0)
            throw new EmptyListException();

        E min = source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(source[i], min) < 0)
                min = source[i];
        }

        return min;
    }

    public void sort(AbstractComparator comparator) {

        for (int i = 0; i < size; i++) {
            E min = source[i];
            int minId = i;

            for (int j = i; j < size; j++) {
                if (comparator.compare(source[j], min) < 0) {
                    min = source[j];
                    minId = j;
                }
            }

            E temp = source[minId];
            source[minId] = source[i];
            source[i] = temp;
        }
    }
}
