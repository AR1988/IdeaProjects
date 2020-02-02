package com.company.collection;


import com.company.comparator.OurComparator;
import com.company.comparator.IntegerOurComparator;
import com.company.comparator.StringComparator;
import org.junit.Test;


import static org.junit.Assert.*;

public class MaxStackTest {

    MaxStack source = new MaxStack();
    OurComparator cp = new IntegerOurComparator();

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersSortedElementsWithComparator() throws EmptyListException {
        source.addLast(2);
        source.addLast(7);
        source.addLast(8);
        source.addLast(16);

        assertEquals(16, source.getMax(cp));
    }

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersNotSortElementsWithComparator() throws EmptyListException {
        source.addLast(7);
        source.addLast(2);
        source.addLast(8);
        source.addLast(20);

        assertEquals(20, source.getMax(cp));
    }

    @Test
    public void testGetMax_FourIntegerElementsWithNegativeNumbersNotSortElementsWithComparator() throws EmptyListException {
        source.addLast(7);
        source.addLast(-1);
        source.addLast(18);
        source.addLast(-10);

        assertEquals(18, source.getMax(cp));
    }

    @Test(expected = EmptyListException.class)
    public void testGetMax_EmptyListExceptionWithComparator() throws EmptyListException {
        source.getMax(cp);
    }

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersSortedElementsNoComparator() throws EmptyListException {
        source.addLast(2);
        source.addLast(7);
        source.addLast(8);
        source.addLast(16);

        assertEquals(16, source.getMax());
    }

    @Test
    public void testGetMax_FourIntegerElementsWithPositiveNumbersNotSortElementsNoComparator() throws EmptyListException {
        source.addLast(7);
        source.addLast(2);
        source.addLast(8);
        source.addLast(20);

        assertEquals(20, source.getMax());
    }

    @Test
    public void testGetMax_FourIntegerElementsWithNegativeNumbersNotSortElementsNoComparator() throws EmptyListException {
        source.addLast(7);
        source.addLast(-1);
        source.addLast(18);
        source.addLast(-10);

        assertEquals(18, source.getMax());
    }

    @Test(expected = EmptyListException.class)
    public void testGetMax_EmptyListExceptionNoComparator() throws EmptyListException {
        source.getMax();
    }

    @Test
    public void testGetMax_FourStringElementsAllLowercase() throws EmptyListException {
        source.addLast("a");
        source.addLast("b");
        source.addLast("c");
        source.addLast("d");

        OurComparator cpString = new StringComparator();

        assertEquals("d", source.getMax(cpString));
    }

    @Test
    public void testGetMax_FourStringElementsFirstUppercaseSecondLowercase() throws EmptyListException {
        source.addLast("a");
        source.addLast("b");
        source.addLast("c");
        source.addLast("A");

        OurComparator cpString = new StringComparator();

        assertEquals("A", source.getMax(cpString));
    }
}