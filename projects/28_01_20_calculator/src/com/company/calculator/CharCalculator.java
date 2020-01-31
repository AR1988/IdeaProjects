package com.company.calculator;

import java.lang.reflect.InvocationTargetException;

public class CharCalculator implements ICalculator {
    private static final String OPERATIONS_PACKAGE = "com.company.calculator.char_operation.";

    //        42 = operand *
    //        43 = operand +
    //        45 = operand -
    //        47 = operand /

    @Override
    public double calculate(double num1, double num2, char operand) throws OperationNotSupportedException {

        String operationPath = getOperationPath(operand);
        Operation operation;
        try {
            operation = (Operation) Class.forName(operationPath).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new OperationNotSupportedException();
        }
        return operation.apply(num1, num2);
    }

    private String getOperationPath(char operand) {
        return OPERATIONS_PACKAGE + "Operation_" + (int) operand;
    }
}
