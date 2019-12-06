package com.company.collection;


public class OurLinkedList implements OurList {

    private int size;
    Node first;
    Node last;

    OurLinkedList() {
    }

    @Override
    public void append(Object value) {
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
    public Object get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node needle = getNode(index);
        return needle.value;
    }

    @Override
    public void set(int index, Object value) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node nodeToSet = getNode(index);
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
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(value)) return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            removeById(getIndex(o));
            return true;
        }
        return false;
    }

    private int getIndex(Object o) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (get(i).equals(o))
                index = i;
        }
        return index;
    }

    @Override
    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node nodeToRemove = getNode(index);

        Node left = nodeToRemove.prev;
        Node right = nodeToRemove.next;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        if (index > 0 && index < size - 1) {
            left.next = right;
            right.prev = left;

            size--;

            return nodeToRemove.value;
        } else if (index == 0) {
            //remove first
            right.prev = nodeToRemove;
            first = right;
            size--;

            return nodeToRemove.value;
        } else {
            //remove last
            left.prev = left;
            last = left;

            last.next = nodeToRemove;
            size--;

            return nodeToRemove.value;
        }
    }

    private static class Node {
        Node() {
        }

        Node(Node next, Node prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node next;
        Node prev;
        Object value;
    }
}