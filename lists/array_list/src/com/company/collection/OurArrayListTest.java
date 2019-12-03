package com.company.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurArrayListTest {

    @Test
    public void TestAddGet_emptyObject_addsOneElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);

        assertEquals(5, list.get(0));
    }

    @Test
    public void TestAddGet_emptyObject_addsSeveralElement() {
        OurArrayList list = new OurArrayList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    public void TestSize_emptyObject_addsOneElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);

        assertEquals(1, list.size());
    }

    @Test
    public void TestSize_emptyObject_addsSeveralElement() {
        OurArrayList list = new OurArrayList();

        Integer[] expected = {1, 3, -10, 18, 4, 3, 7, 1, 3, 3, 3, 5, 5, 10, -18, 22, 28, 60, 15, 20};
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        assertEquals(expected.length, list.size());
    }

    @Test
    public void TestSet_oneElement_swapsElement() {
        OurArrayList list = new OurArrayList();
        list.add(0);
        list.set(0, 10);

        assertEquals(10, list.get(0));
    }

    @Test
    public void TestSet_severalElement_swapsFirstLastMiddleElements() {
        OurArrayList list = new OurArrayList();

        Integer[] source = {1, 3, -10, 18, 4};
        for (int i = 0; i < source.length; i++) {
            list.add(source[i]);
        }

        list.set(0, 10);
        list.set(4, 5);
        list.set(2, -5);

        Integer[] expected = {10, 3, -5, 18, 5};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestGet_nonEmptyObject_expected_expected_takeOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestSet_nonEmptyObject_expected_putOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.set(4, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestRemoveById_nonEmptyObject_removesOuterElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);

        list.removeById(4);
    }

    @Test
    public void TestRemoveById_nonEmptyObject_removesFirstElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);
        list.add(17);
        list.add(20);

        Object object = list.removeById(0);
        assertEquals(5, object);

        Integer[] expected = {15, 2, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void TestRemoveById_nonEmptyObject_removesMiddleElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);
        list.add(17);
        list.add(20);

        Object object = list.removeById(2);
        assertEquals(2, object);

        Integer[] expected = {5, 15, 5, 17, 20};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
    }

    @Test
    public void TestRemoveById_nonEmptyObject_removesLastElement() {
        OurArrayList list = new OurArrayList();

        list.add(5);
        list.add(15);
        list.add(2);
        list.add(5);
        list.add(17);
        list.add(20);

        Object object = list.removeById(5);
        assertEquals(20, object);

        Integer[] expected = {5, 15, 2, 5, 17};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }

        assertEquals(5, list.size());
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

}