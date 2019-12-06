package com.company.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurLinkedListTest {

    @Test
    public void append() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(20);

        assertEquals(10,linkedList.get(0));
        assertEquals(20,linkedList.get(1));
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        linkedList.set(1,999);

        assertEquals(999,linkedList.get(1));

    }

    @Test
    public void size() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        assertEquals(1, linkedList.size());
        linkedList.append(3);
        assertEquals(2,linkedList.size());
        linkedList.append(20);
        assertEquals(3,linkedList.size());
        linkedList.append(110);
        assertEquals(4,linkedList.size());

    }


    @Test
    public void contains() {
    }

    @Test
    public void remove() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        linkedList.remove(10);

        assertFalse(linkedList.contains(10));
        assertEquals(3,linkedList.size());

        linkedList.remove(110);
        assertFalse(linkedList.contains(110));
        assertEquals(2,linkedList.size());
    }

    @Test
    public void removeById() {
    }
}