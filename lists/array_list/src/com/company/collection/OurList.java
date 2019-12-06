package com.company.collection;

public interface OurList {
    void append(Object o);

    Object get(int index);

    void set(int index, Object value);

    int size();

    boolean contains();

    boolean remove(Object o);

    Object removeById(int index);
}
