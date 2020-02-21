package com.company.operations.text_operation;

import com.company.operations.Operation;

public class Operation_Reverse implements Operation {

    @Override
    public String perform(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        return stringBuilder.reverse().toString();
    }
}
