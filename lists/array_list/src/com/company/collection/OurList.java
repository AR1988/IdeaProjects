package com.company.collection;

public interface OurList<E> {
    void append(E o);

    E get(int index);

    void set(int index, E value);

    int size();

    boolean contains(E value);

    boolean remove(E o);

    E removeById(int index);
}
