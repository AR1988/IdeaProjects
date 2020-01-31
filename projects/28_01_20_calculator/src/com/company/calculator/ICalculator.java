package com.company.calculator;

import com.company.exception.OperationNotSupportedException;

public interface ICalculator {

    double calculate(double num1, double num2, char operand) throws OperationNotSupportedException;
}
