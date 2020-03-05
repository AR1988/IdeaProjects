package com.company;


import java.util.Map;


public class OperationProvider {

    Map<String, IOperation> operationByName;

    public OperationProvider(Map<String, IOperation> operationByName) {
        this.operationByName = operationByName;
    }

    public IOperation getByName(String str) {
        return operationByName.get(str);
    }
}
