package com.company.operation;

import com.company.IOperation;

/**
 * @return reversed line
 */
public class ReverseOperation implements IOperation {
    @Override
    public String getName() {
        return "reverse";
    }

    @Override
    public String operate(String input) {
        StringBuilder res = new StringBuilder();
        res.append(input);
        return res.reverse().toString();
    }
}
