package com.company.calculator;

import com.company.exception.OperationNotSupported;

import java.util.ArrayList;
import java.util.List;

public class LineProcessor {

    private static final String DELIMITER = " ";

    private String delimiter = DELIMITER;
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
            return "Error at line: \"" + line + "\" -> wrong input format";
        }

        double num1;
        try {
            num1 = Double.parseDouble(members[0]);
        } catch (NumberFormatException e) {
            return "Error at line: \"" + line + "\" -> unsupported input format \"" + members[0] + "\"";
        }

        double num2;
        try {
            num2 = Double.parseDouble(members[2]);
        } catch (NumberFormatException e) {
            return "Error at line: \"" + line + "\" -> unsupported input format \"" + members[2] + "\"";
        }

        char operand = members[1].charAt(0);
        double res;
        try {
            res = calculator.calculate(num1, num2, operand);
        } catch (OperationNotSupported operationNotSupported) {
            return "Error at line: " + line + " -> unsupported operand \"" + members[1] + "\"";
        }
        return line + delimiter + res;
    }
}
