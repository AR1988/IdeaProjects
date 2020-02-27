package com.company;

import java.util.Map;

public class OperationProvider {

    private final Map<String, IOperation> operationByName;


    private static final String OPERATIONS_PACKAGE = "com.company.operation.";

//    Map<String, IOperation> operationByName = new HashMap<>();
//        operationByName.put("lowercase", new LowerCaseOperation());
//        operationByName.put("uppercase", new UpperCaseOperation());

    public OperationProvider(Map<String, IOperation> operationByName) {
        this.operationByName = operationByName;
    }

    public IOperation getByName(String name) {
        return operationByName.get(name);
    }

//    /**
//     * @param operationName name of operation
//     * @return implemented object from interface IOperation
//     * @throws OperationNotSupportedException if operation not supported
//     */
//    public IOperation getByName(String operationName) throws OperationNotSupportedException {
//        String operationPath = OPERATIONS_PACKAGE + operationName;
//        IOperation operation;
//        try {
//            operation = (IOperation) Class.forName(operationPath).getConstructor().newInstance();
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
//            throw new OperationNotSupportedException();
//        }
//        return operation;
//
//    }
}

