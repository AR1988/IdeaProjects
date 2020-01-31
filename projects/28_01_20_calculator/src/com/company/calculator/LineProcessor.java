package com.company.calculator;

import java.util.ArrayList;
import java.util.List;

public class LineProcessor {

     static final String DELIMITER = ",";
     static final String AT_LINE_ERROR = "Error at line: -> ";

     static final String WRONG_INPUT_FORMAT_ERROR = " -> wrong input format.";
     static final String UNSUPPORTED_INPUT_FORMAT_ERROR_NUM1 = " -> unsupported input format -> NUM1.";
     static final String UNSUPPORTED_INPUT_FORMAT_ERROR_NUM2 = " -> unsupported input format -> NUM2.";
     static final String UNSUPPORTED_OPERAND_ERROR = " -> unsupported operand -> ";

    String delimiter = DELIMITER;
    private ICalculator calculator;

    public LineProcessor(ICalculator calculator) {
        this.calculator = calculator;
    }

    public LineProcessor(String delimiter, ICalculator calculator) {
        this.delimiter = delimiter;
        this.calculator = calculator;
    }

    public List<String> processLines(List<String> content) {
        List<String> res = new ArrayList<>();
        for (String line : content) {
            res.add(processLine(line));
        }
        return res;
    }

    String processLine(String line) {
        String[] members = line.split(delimiter);
        if (members.length != 3) {
            return AT_LINE_ERROR + line + WRONG_INPUT_FORMAT_ERROR;
        }

        double num1;
        try {
            num1 = Double.parseDouble(members[0]);
        } catch (NumberFormatException e) {
            return AT_LINE_ERROR + line + UNSUPPORTED_INPUT_FORMAT_ERROR_NUM1;
        }

        double num2;
        try {
            num2 = Double.parseDouble(members[2]);
        } catch (NumberFormatException e) {
            return AT_LINE_ERROR + line + UNSUPPORTED_INPUT_FORMAT_ERROR_NUM2;
        }

        char operand = members[1].charAt(0);
        double res;
        try {
            res = calculator.calculate(num1, num2, operand);
        } catch (OperationNotSupportedException operationNotSupported) {
            return AT_LINE_ERROR + line + UNSUPPORTED_OPERAND_ERROR + delimiter;
        }
        return line + delimiter + res;
    }
}
