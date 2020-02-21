package com.company.operations;


import java.lang.reflect.InvocationTargetException;

public class GetOperationName extends Thread  {
    private static final String OPERATIONS_PACKAGE = "com.company.operations.text_operation.";

    String operation;

    public String addOperation(String str, String operation) throws OperationNotSupportedException {
        String operationPath = getOperationPath(operation);
        Operation operationToApply;

        try {
            operationToApply = (Operation) Class.forName(operationPath).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new OperationNotSupportedException();
        }

        return operationToApply.perform(str);
    }

    String getOperationPath(String operation) {
        return OPERATIONS_PACKAGE + "Operation_" + operation;
    }
}
