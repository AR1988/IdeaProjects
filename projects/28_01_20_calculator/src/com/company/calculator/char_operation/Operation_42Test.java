package com.company.calculator.char_operation;

import com.company.calculator.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class Operation_42Test {
    private Operation operation = new Operation_42();

    @Test
    public void testApply_zeroAndNonZero() {
        assertEquals(0.0, operation.apply(0, 2.5), 0.00001);
    }

    @Test
    public void testApply_nonZeroAndZero() {
        assertEquals(0.0, operation.apply(2.89, 0), 0.00001);
    }

    @Test
    public void testApply_nonZeroAndNonZero() {
        assertEquals(-10.115, operation.apply(2.89, -3.5), 0.00001);
    }

}