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

        Node oldNodle = getNode(index);
        Node newNode = new Node(oldNodle.next, oldNodle.prev, value);
        System.out.printf("");
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
    public boolean contains() {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object removeById(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        if (index > 0 || index < size - 1) {
            Node nodeToRemove = getNode(index); //цель по индексу
            Node left = nodeToRemove.prev;      //перемещение влево
            Node right = nodeToRemove.next;     // перемещение вправо

            nodeToRemove.next = null;
            nodeToRemove.prev = null;

            left.next = right;
            right.prev = left;
            return nodeToRemove.value;
        } else if (index == 0) {
            //remove first
        } else {
            //remove last
        }
        return null;
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