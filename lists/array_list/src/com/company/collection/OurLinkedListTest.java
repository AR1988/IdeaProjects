package com.company.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurLinkedListTest {

    @Test
    public void append() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(20);

        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
    }

    @Test
    public void get() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(20);

        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
    }

    @Test
    public void set() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);
        linkedList.append(0);

        linkedList.set(0, -5);
        linkedList.set(1, 50);
        linkedList.set(2, 7);
        linkedList.set(3, 9);
        linkedList.set(4, 999);

        assertEquals(-5, linkedList.get(0));
        assertEquals(50, linkedList.get(1));
        assertEquals(7, linkedList.get(2));
        assertEquals(9, linkedList.get(3));
        assertEquals(999, linkedList.get(4));

    }

    @Test
    public void size() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        assertEquals(1, linkedList.size());
        linkedList.append(3);
        assertEquals(2, linkedList.size());
        linkedList.append(20);
        assertEquals(3, linkedList.size());
        linkedList.append(110);
        assertEquals(4, linkedList.size());

    }


    @Test
    public void contains() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        assertTrue(linkedList.contains(10));
        assertTrue(linkedList.contains(3));
        assertTrue(linkedList.contains(20));
        assertTrue(linkedList.contains(110));

        assertFalse(linkedList.contains(-10));
        assertFalse(linkedList.contains(-3));
        assertFalse(linkedList.contains(-20));
        assertFalse(linkedList.contains(-110));
        assertFalse(linkedList.contains(0));
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
        assertEquals(3, linkedList.size());

        linkedList.remove(110);
        assertFalse(linkedList.contains(110));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void removeById_NotRemoveIdFirstIdLast() {
        OurLinkedList linkedList = new OurLinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.append(i);
        }

        // removeById index 1
        assertTrue(linkedList.contains(1));
        assertEquals(10, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(1));
        assertEquals(9, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(2));
        assertEquals(9, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(2));
        assertEquals(8, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(3));
        assertEquals(8, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(3));
        assertEquals(7, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(4));
        assertEquals(7, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(4));
        assertEquals(6, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(5));
        assertEquals(6, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(5));
        assertEquals(5, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(6));
        assertEquals(5, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(6));
        assertEquals(4, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(7));
        assertEquals(4, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(7));
        assertEquals(3, linkedList.size());

        // removeById index 1
        assertTrue(linkedList.contains(8));
        assertEquals(3, linkedList.size());
        linkedList.removeById(1);
        assertFalse(linkedList.contains(8));
        assertEquals(2, linkedList.size());

    }

    @Test
    public void removeById_FirstId() {
        OurLinkedList linkedList = new OurLinkedList();

        for (int i = 0; i < 5; i++) {
            linkedList.append(i);
        }

        assertEquals(5, linkedList.size());
        assertTrue(linkedList.contains(0));
        linkedList.removeById(0);
        assertFalse(linkedList.contains(0));
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(4, linkedList.size());

        assertEquals(4, linkedList.size());
        assertTrue(linkedList.contains(1));
        linkedList.removeById(0);
        assertEquals(2, linkedList.get(0));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.contains(1));

        assertEquals(3, linkedList.size());
        assertTrue(linkedList.contains(2));
        linkedList.removeById(0);
        assertEquals(3, linkedList.get(0));
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains(2));


        assertEquals(2, linkedList.size());
        assertTrue(linkedList.contains(3));
        linkedList.removeById(0);
        assertEquals(4, linkedList.get(0));
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.contains(3));

    }

    @Test
    public void removeById_LasttId() {
        OurLinkedList linkedList = new OurLinkedList();

        for (int i = 0; i < 5; i++) {
            linkedList.append(i);
        }

        assertEquals(5, linkedList.size());
        assertTrue(linkedList.contains(4));
        linkedList.removeById(4);
        assertEquals(3, linkedList.get(3));
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.contains(4));

        assertEquals(4, linkedList.size());
        assertTrue(linkedList.contains(3));
        linkedList.removeById(3);
        assertEquals(2, linkedList.get(2));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.contains(3));

        assertEquals(3, linkedList.size());
        assertTrue(linkedList.contains(2));
        linkedList.removeById(2);
        assertEquals(1, linkedList.get(1));
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains(2));

        assertEquals(2, linkedList.size());
        assertTrue(linkedList.contains(1));
        linkedList.removeById(1);
        assertEquals(0, linkedList.get(0));
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.contains(1));

    }


}