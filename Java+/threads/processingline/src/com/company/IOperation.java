package com.company;

public interface IOperation {
    /**
     * @return operation name
     */
    String getName();

    /**
     * @param input string to edit
     * @return result from input :string
     * @throws OperationNotSupportedException
     */
    String operate(String input) throws OperationNotSupportedException;
}
