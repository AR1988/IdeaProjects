package com.company.operation;

import com.company.IOperation;

/**
 * @return "input" to lower case
 */
public class LowerCaseOperation implements IOperation {
    @Override
    public String getName() {
        return "lowercase";
    }

    @Override
    public String operate(String input) {
        return input.toLowerCase();
    }
}
