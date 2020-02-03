package com.company.collection;


import com.company.comparator.OurComparator;
import com.company.comparator.IntegerOurComparator;
import com.company.comparator.StringComparator;
import org.junit.Test;


import static org.junit.Assert.*;

public class OurStackTest {

    OurStack<Integer> sourceInt = new OurStack<>();
    OurStack<String> sourceStr = new OurStack<>();
    OurComparator cpInt = new IntegerOurComparator();
    OurComparator cpString = new StringComparator();

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersSortedElementsWithComparator() throws EmptyListException {
        sourceInt.addLast(2);
        sourceInt.addLast(7);
        sourceInt.addLast(8);
        sourceInt.addLast(16);

        assertEquals((Integer) 16, sourceInt.getMax(cpInt));
    }

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersNotSortElementsWithComparator() throws EmptyListException {
        sourceInt.addLast(7);
        sourceInt.addLast(2);
        sourceInt.addLast(8);
        sourceInt.addLast(20);

        assertEquals((Integer)20, sourceInt.getMax(cpInt));
    }

    @Test
    public void testGetMax_FourIntegerElementsWithNegativeNumbersNotSortElementsWithComparator() throws EmptyListException {
        sourceInt.addLast(7);
        sourceInt.addLast(-1);
        sourceInt.addLast(18);
        sourceInt.addLast(-10);

        assertEquals((Integer)18, sourceInt.getMax(cpInt));
    }

    @Test(expected = EmptyListException.class)
    public void testGetMax_EmptyListExceptionWithComparator() throws EmptyListException {
        sourceInt.getMax(cpInt);
    }

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersSortedElementsNoComparator() throws EmptyListException {
        sourceInt.addLast(2);
        sourceInt.addLast(7);
        sourceInt.addLast(8);
        sourceInt.addLast(16);

        assertEquals(16, sourceInt.getMax());
    }

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersNotSortElementsNoComparator() throws EmptyListException {
        sourceInt.addLast(7);
        sourceInt.addLast(2);
        sourceInt.addLast(8);
        sourceInt.addLast(20);

        assertEquals(20, sourceInt.getMax());
    }

    @Test
    public void testGetMax_FourIntegerElementsWithNegativeNumbersNotSortElementsNoComparator() throws EmptyListException {
        sourceInt.addLast(7);
        sourceInt.addLast(-1);
        sourceInt.addLast(18);
        sourceInt.addLast(-10);

        assertEquals(18, sourceInt.getMax());
    }

    @Test(expected = EmptyListException.class)
    public void testGetMax_EmptyListExceptionNoComparator() throws EmptyListException {
        sourceInt.getMax();
    }

    @Test
    public void testGetMax_FourStringElementsAllLowercase() throws EmptyListException {
        sourceStr.addLast("a");
        sourceStr.addLast("b");
        sourceStr.addLast("c");
        sourceStr.addLast("d");

        OurComparator cpString = new StringComparator();

        assertEquals("d", sourceStr.getMax(cpString));
    }

    @Test
    public void testGetMax_FourStringElementsWithUppercaseAndLowercase() throws EmptyListException {
        sourceStr.addLast("b");
        sourceStr.addLast("A");
        sourceStr.addLast("C");
        sourceStr.addLast("a");

        assertEquals("b", sourceStr.getMax(cpString));
    }

    @Test
    public void testGetMax_FourStringElementsAllUppercaseElements() throws EmptyListException {
        sourceStr.addLast("B");
        sourceStr.addLast("A");
        sourceStr.addLast("D");
        sourceStr.addLast("G");

        assertEquals("G", sourceStr.getMax(cpString));
    }
}