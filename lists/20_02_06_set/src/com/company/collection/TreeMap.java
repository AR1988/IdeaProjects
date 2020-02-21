package com.company.collection;

import java.util.Iterator;

public class TreeMap<E> implements OurSet<E> {

    @Override
    public boolean add(E elt) {
        return false;
    }

    @Override
    public boolean remove(E elt) {
        return false;
    }

    @Override
    public boolean contains(E elt) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean addAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

class TreeNode {

    TreeNode left;
    TreeNode right;
}