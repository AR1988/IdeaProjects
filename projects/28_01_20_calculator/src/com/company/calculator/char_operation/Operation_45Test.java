package com.company.calculator.char_operation;

import com.company.calculator.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class Operation_45Test {
    private Operation operation = new Operation_45();

    @Test
    public void testApply_zeroAndNonZero() {
        assertEquals(-2.5, operation.apply(0, 2.5), 0.00001);
    }

    @Test
    public void testApply_nonZeroAndZero() {
        assertEquals(2.89, operation.apply(2.89, 0), 0.00001);
    }

    @Test
    public void testApply_nonZeroAndNonZero() {
        assertEquals(6.48, operation.apply(2.89, -3.59), 0.00001);
    }

}