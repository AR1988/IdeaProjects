package com.company.calculator.char_operation;

import com.company.calculator.Operation;

public class Operation_42 implements Operation {
    @Override
    public double apply(double num1, double num2) {
        return num1 * num2;
    }
}
