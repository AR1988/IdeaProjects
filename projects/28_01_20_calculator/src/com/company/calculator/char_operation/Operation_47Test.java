package com.company.calculator.char_operation;

import com.company.calculator.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class Operation_47Test {
    private Operation operation = new Operation_47();

    @Test
    public void testApply_zeroAndNonZero() {
        assertEquals(0, operation.apply(0, 2.5), 0.00001);
    }

    @Test
    public void testApply_nonZeroAndZero() {
//        assertEquals(operation.apply(2.89, 0), Infinity);
//        assertEquals(2.89, operation.apply(2.89, 0), 0.00001);
    }

    @Test
    public void testApply_nonZeroAndNonZero() {
        assertEquals( operation.apply(2.89, -3.5),-0.61, 0.00001);
    }
}