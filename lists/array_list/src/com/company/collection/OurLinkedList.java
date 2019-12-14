package com.company.collection;


public class OurLinkedList<E> implements OurList<E> {

    private int size;
    private Node first;
    private Node last;

    public OurLinkedList() {
    }

    @Override
    public void append(E value) {
        if (size > 0) {
            Node newNode = new Node(null, last, value);
            last.next = newNode;
            last = newNode;
        } else {
            Node newNode = new Node();
            newNode.value = value;
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> needle = getNode(index);
        return needle.value;
    }

    @Override
    public void set(int index, E value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> nodeToSet = getNode(index);
        nodeToSet.value = value;
    }

    //ищет и выдат об по индексу
    private Node getNode(int index) {

        Node needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }
        return needle;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E value) {
        Node needle = first;
        for (int i = 0; i < size; i++) {
            if (needle.value.equals(value)) {
                return true;
            }
            needle = needle.next;
        }
        return false;
    }

    @Override
    public boolean remove(E value) {

        int index = 0;
        Node needle = first;
        for (int i = 0; i < size; i++) {
            if (needle.value.equals(value)) {
                removeById(index);
                return true;
            }
            needle = needle.next;
            index++;
        }
        return false;
    }

    private int getIndex(E value) {
        int index = 0;
        Node needle = first;

        for (int i = 0; i < size; i++) {
            if (needle.value.equals(value)) {
                return index;
            }
            needle = needle.next;
            index++;
        }
        return -1;
    }

    @Override
    public E removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> nodeToRemove = getNode(index);

        Node<E> left = nodeToRemove.prev;
        Node<E> right = nodeToRemove.next;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        if (index > 0 && index < size - 1) {
//            remove in list
            left.next = right;
            right.prev = left;

        } else if (index == 0) {
//            remove first
            right.prev = null;
            first = right;
        } else {
//            remove last
            left.next = null;
            last = left;
        }
        size--;
        return nodeToRemove.value;
    }

    private static class Node<E> {
        Node() {
        }

        Node(Node next, Node prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node next;
        Node prev;
        E value;
    }
}