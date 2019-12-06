package com.company.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurLinkedListTest {

    //region append - completed
    @Test
    public void append() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(20);

        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
    }
    //endregion

    //region get - completed
    @Test
    public void get() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(20);

        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
    }
    //endregion -  -

    //region set - completed
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void Set_nIndexOutOfBoundsException() {
        OurLinkedList linkedList = new OurLinkedList();

        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        linkedList.set(5, 8);
    }
    //endregion

    //region size
    @Test
    public void size_appendObjects() {
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
    public void size_removedObjects() {
        OurLinkedList linkedList = new OurLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.append(i*10);
        }

        assertEquals(10, linkedList.size()); //start size = 10
        //remove 3 elements, size = 7
        linkedList.remove(90);
        assertEquals(9, linkedList.size());
        linkedList.remove(20);
        assertEquals(8, linkedList.size());
        linkedList.remove(0);
        assertEquals(7, linkedList.size());
    }

    @Test
    public void size_removeByIdObjects() {
        OurLinkedList linkedList = new OurLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.append(i*10);
        }

        assertEquals(10, linkedList.size()); //start size = 10
        //removeById 4 Elements, size = 6
        linkedList.removeById(9);
        assertEquals(9, linkedList.size());
        linkedList.removeById(0);
        assertEquals(8, linkedList.size());
        linkedList.removeById(1);
        assertEquals(7, linkedList.size());
        linkedList.removeById(0);
        assertEquals(6, linkedList.size());

    }

    @Test
    public void size_RemoveAndAppendAndRemoveByIdObjects() {
        OurLinkedList linkedList = new OurLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.append(i);
        }

        assertEquals(10, linkedList.size()); //start size = 10
        //remove 2 elements, size = 8
        linkedList.remove(1);
        assertEquals(9, linkedList.size());
        linkedList.remove(5);
        assertEquals(8, linkedList.size());


        //append 3 element, size = 11
        linkedList.append(17);
        assertEquals(9, linkedList.size());
        linkedList.append(20);
        assertEquals(10, linkedList.size());
        linkedList.append(77);
        assertEquals(11, linkedList.size());


        //removeById 4 Elements, size = 7
        linkedList.removeById(1);
        assertEquals(10, linkedList.size());
        linkedList.removeById(2);
        assertEquals(9, linkedList.size());
        linkedList.removeById(0);
        assertEquals(8, linkedList.size());
        linkedList.removeById(5);
        assertEquals(7, linkedList.size());

    }

    //endregion

    //region contains
    @Test
    public void contains_True() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        assertTrue(linkedList.contains(10));
        assertTrue(linkedList.contains(3));
        assertTrue(linkedList.contains(20));
        assertTrue(linkedList.contains(110));
    }

    @Test
    public void contains_False() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        assertFalse(linkedList.contains(-10));
        assertFalse(linkedList.contains(-3));
        assertFalse(linkedList.contains(-20));
        assertFalse(linkedList.contains(-110));
        assertFalse(linkedList.contains(0));
    }

    //endregion

    //region remove
    @Test
    public void remove_object() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        assertTrue(linkedList.contains(10));           //is contains o:10? true
        linkedList.remove(10);                      //remove o:10
        assertFalse(linkedList.contains(10));          //is contains o:10? false
        assertEquals(3, linkedList.size());

        assertTrue(linkedList.contains(110));
        linkedList.remove(110);
        assertFalse(linkedList.contains(110));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void remove_true() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        assertTrue(linkedList.remove(10));
        assertTrue(linkedList.remove(3));
        assertTrue(linkedList.remove(110));
    }

    @Test
    public void remove_false() {
        OurLinkedList linkedList = new OurLinkedList();
        linkedList.append(10);
        linkedList.append(3);
        linkedList.append(20);
        linkedList.append(110);

        assertFalse(linkedList.remove(0));
        assertFalse(linkedList.remove(-20));
        assertFalse(linkedList.remove(109));
    }

    //endregion

    //region removeById
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
        // removeById index 0
        assertEquals(5, linkedList.size());
        assertTrue(linkedList.contains(0));

        System.out.println("\nStart: ");
        for (int i = 0; i < linkedList.size() ; i++) {
            System.out.print(linkedList.get(i) + " ");
        }

        linkedList.removeById(0);
        assertFalse(linkedList.contains(0));
        assertEquals(1, linkedList.get(0));
        System.out.println("\nremoved 0");

        for (int i = 0; i < linkedList.size() ; i++) {
            System.out.print(linkedList.get(i) + " ");
        }

        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
        assertEquals(4, linkedList.get(3));
        assertEquals(4, linkedList.size());

        // removeById index 0
        assertEquals(4, linkedList.size());
        assertTrue(linkedList.contains(1));
        linkedList.removeById(0);
        assertEquals(2, linkedList.get(0));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.contains(1));

        System.out.println("\nremoved 1");
        for (int i = 0; i < linkedList.size() ; i++) {
            System.out.print(linkedList.get(i) + " ");
        }

        // removeById index 0
        assertEquals(3, linkedList.size());
        assertTrue(linkedList.contains(2));
        linkedList.removeById(0);
        assertEquals(3, linkedList.get(0));
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains(2));

        System.out.println("\nremoved 2");
        for (int i = 0; i < linkedList.size() ; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        // removeById index 0
        assertEquals(2, linkedList.size());
        assertTrue(linkedList.contains(3));
        linkedList.removeById(0);
        assertEquals(4, linkedList.get(0));
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.contains(3));

        System.out.println("\nremoved 3");
        for (int i = 0; i < linkedList.size() ; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }

    @Test
    public void removeById_LasttId() {
        OurLinkedList linkedList = new OurLinkedList();

        for (int i = 0; i < 5; i++) {
            linkedList.append(i);
        }
        // removeById index last
        assertEquals(5, linkedList.size());
        assertTrue(linkedList.contains(4));
        linkedList.removeById(4);
        assertEquals(3, linkedList.get(3));
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.contains(4));
        // removeById index last
        assertEquals(4, linkedList.size());
        assertTrue(linkedList.contains(3));
        linkedList.removeById(3);
        assertEquals(2, linkedList.get(2));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.contains(3));
        // removeById index last
        assertEquals(3, linkedList.size());
        assertTrue(linkedList.contains(2));
        linkedList.removeById(2);
        assertEquals(1, linkedList.get(1));
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains(2));
        // removeById index last
        assertEquals(2, linkedList.size());
        assertTrue(linkedList.contains(1));
        linkedList.removeById(1);
        assertEquals(0, linkedList.get(0));
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.contains(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeById_IndexOutOfBoundsException() {
        OurLinkedList linkedList = new OurLinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.append(i);
        }
        linkedList.removeById(11);
        linkedList.removeById(15);
    }
//endregion
}