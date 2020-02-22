package com.company.operation;

import com.company.IOperation;

/**
 * @return "input" to upper case
 */
public class UpperCaseOperation implements IOperation {

    @Override
    public String getName() {
        return "uppercase";
    }

    @Override
    public String operate(String input) {
        return input.toUpperCase();
    }
}
