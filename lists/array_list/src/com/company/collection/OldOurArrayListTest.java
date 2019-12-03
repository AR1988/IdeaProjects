package com.company.collection;


import org.junit.Test;

import static org.junit.Assert.*;


public class OldOurArrayListTest {

    @Test
    public void TestSize_AddElements_EqualsResult() {
        OurArrayList list = new OurArrayList();

        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(list.size(), 3);

    }

    @Test
    public void TestSize_AddElementWithId_EqualsResult() {
        OurArrayList list = new OurArrayList();

        list.set(1, 0);
        list.set(10, 10);
        list.set(8, 8);
        assertEquals(list.size(), 3);

    }

    @Test
    public void TestSize_Add12ElementsAndRemoveThis_EqualsResult() {
        OurArrayList list = new OurArrayList();

        for (int i = 0; i < 13; i++) {
            list.add(i);
        }
        assertEquals(list.size(), 13);
        list.removeById(0);
        assertEquals(list.size(), 12);
        list.removeById(1);
        assertEquals(list.size(), 11);
        list.removeById(2);
        assertEquals(list.size(), 10);

        list.remove(8);
        assertEquals(list.size(), 9);
        list.remove(11);
        assertEquals(list.size(), 8);
        list.remove(10);
        assertEquals(list.size(), 7);
        list.remove(6);
        assertEquals(list.size(), 6);

    }

    @Test
    public void TestSize_Add12ElementsAndRemoveByIdThis_EquasResult() {
        OurArrayList list = new OurArrayList();

        for (int i = 0; i < 13; i++) {
            list.add(i);
        }

        assertEquals(list.size(), 13);
        list.removeById(0);
        assertEquals(list.size(), 12);
        list.removeById(1);
        assertEquals(list.size(), 11);
        list.removeById(2);
        assertEquals(list.size(), 10);

        list.add(10);
        assertEquals(list.size(), 11);
        list.add(10);
        assertEquals(list.size(), 12);


        list.removeById(1);
        assertEquals(list.size(), 11);
        list.removeById(0);
        assertEquals(list.size(), 10);
    }

    @Test
    public void testAddandGet_AddSameElements_GetSameElements_EqualsEmptyPos() {
        OurArrayList list = new OurArrayList();

        list.add(700);
        list.add(-20);
        list.add(0);
        assertEquals(list.get(0), 700);
        assertEquals(list.get(1), -20);
        assertEquals(list.get(2), 0);

        assertNull(list.get(3));
        assertNull(list.get(4));
        assertNull(list.get(5));
        assertNull(list.get(15));

        list.add(5);
        assertEquals(list.get(3), 5);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_nonEmptyObject_takeOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.get(4);
    }

    @Test
    public void TestSet_SetRandom7Elements_EqualsThisElementsWithGetIndex() {
        OurArrayList list = new OurArrayList();

        list.set(15, -90);
        list.set(10, 0);
        list.set(14, 0);
        list.set(4, 8);
        list.set(8, 8);
        list.set(0, 10);
        list.set(1, 10);

        assertEquals(list.get(0), 10);
        assertEquals(list.get(1), 10);
        assertEquals(list.get(4), 8);
        assertEquals(list.get(8), 8);
        assertEquals(list.get(10), 0);
        assertEquals(list.get(14), 0);
        assertEquals(list.get(15), -90);

        assertNull(list.get(2));
        assertNull(list.get(3));
        assertNull(list.get(5));
        assertNull(list.get(13));
    }

    @Test
    public void TestSet_SetElementsOnNull_EqualsThisElementsWithGetIndex() {
        OurArrayList list = new OurArrayList();

        list.set(15, -90);
        list.set(10, 0);
        list.set(14, 0);
        list.set(4, 8);
        list.set(8, 8);
        list.set(0, 10);
        list.set(1, 10);

        assertEquals(list.get(0), 10);
        assertEquals(list.get(1), 10);
        assertEquals(list.get(4), 8);
        assertEquals(list.get(8), 8);
        assertEquals(list.get(10), 0);
        assertEquals(list.get(14), 0);
        assertEquals(list.get(15), -90);

        assertNull(list.get(2));
        assertNull(list.get(3));
        assertNull(list.get(5));
        assertNull(list.get(13));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void TestSet_nonEmptyObject_takeOuterElements() {
        OurArrayList list = new OurArrayList();

        list.set(0, -90);
        list.set(1, -80);
        list.set(2, -70);
        list.set(3,-60);

        list.set(4,0);
    }

    @Test
    public void TestRemove_RemoveElementsAndRepeatedElements_EqualsResult() {
        OurArrayList list = new OurArrayList();
        //Elements
        list.add(16);
        list.remove(16);
        assertNull(list.get(0));
        assertEquals(list.size(), 0);
        //Repeated Elements
        list.add(66);
        list.add(66);
        list.add(66);
        list.remove(66);
        assertEquals(list.get(0), 66);
        assertEquals(list.get(1), 66);
        assertNull(list.get(2));
        assertEquals(list.size(), 2);
    }

    @Test
    public void TestRemove_RemoveElementsAndRepeatedElements_TrueFalse() {
        OurArrayList list = new OurArrayList();

        for (int i = 0; i < 17; i++) {
            list.add(i);
        }
        list.set(20, 20);
        list.set(5, 14);
        list.set(26, -20);
        list.set(27, -20);
        list.set(10, 555);

        assertEquals(list.get(20), 20);
        assertEquals(list.get(26), -20);
        assertEquals(list.get(5), 14);
        assertEquals(list.get(27), -20);
        assertEquals(list.get(10), 555);
    }

    @Test
    public void removeById() {
        OurArrayList list = new OurArrayList();
        OurArrayList list2 = new OurArrayList();
        for (int i = 0; i < 18; i++) {
            list.add(i);
        }
        for (int i = 0; i < 18; i++) {
            list2.add(i);
        }

        list.removeById(0);
        assertNotEquals(list.get(0), 0);
        list.add(0);
        list.removeById(5);
        assertNotEquals(list.get(6), 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_nonEmptyObject_putOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.set(4, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveById_nonEmptyObject_removesOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.removeById(4);
    }
}