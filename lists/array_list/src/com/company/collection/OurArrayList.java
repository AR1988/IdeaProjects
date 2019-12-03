package com.company.collection;

import java.util.Arrays;

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

//    public int lenght() {
//        return source.length;
//    }

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
        return source[index];
    }

    public void set(int index, Object value) {
        Object[] newSource = new Object[source.length];

        if (index < source.length && source[index] != null) {
            System.arraycopy(source, 0, newSource, 0, index);
            System.arraycopy(source, index + 1, newSource, index + 1, source.length - (index + 1));
            newSource[index] = value;
            source = newSource;
            size++;
        } else {
            System.out.println("invalid index \"" + index + "\". Enter index from \"0 to " + (source.length - 1) + "\"");
        }
    }

    public boolean remove(Object value) {

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

//    public void display() {
//        System.out.println(Arrays.toString(source));
//    }

}

