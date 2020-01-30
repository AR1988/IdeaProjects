package com.company.test;

import com.company.calculator.CharCalculator;
import com.company.calculator.ICalculator;
import com.company.calculator.LineProcessor;
import com.company.exception.OperationNotSupported;
import com.company.util.FileOperations;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class calculatorTest {

    private ICalculator calculator = new CharCalculator();
    private double num1 = 15.6;
    private double num2 = 17.5;

    private double num3 = 16.7;
    private double num4 = -28.9;

    private char plus = '+';

    @Test
    public void testCalculate_twoDoubleOperandPlus_ResultPositive() throws OperationNotSupported {
        assertEquals(num1 + num2, calculator.calculate(num1, num2, plus), 0.0);
        assertEquals(num2 + num1, calculator.calculate(num2, num1, plus), 0.0);
    }

    @Test
    public void testCalculate_twoDoubleOperandPlus_ResultNegative() throws OperationNotSupported {
        assertEquals(num3 + num4, calculator.calculate(num3, num4, plus), 0.0);
        assertEquals(num4 + num3, calculator.calculate(num4, num3, plus), 0.0);
    }

    private char minus = '-';

    @Test
    public void testCalculate_twoDoubleOperandMinus_ResulttPositive() throws OperationNotSupported {
        assertEquals(num1 - num2, calculator.calculate(num1, num2, minus), 0.0);
        assertEquals(num2 - num1, calculator.calculate(num2, num1, minus), 0.0);
    }

    @Test
    public void testCalculate_twoDoubleOperandMinus_ResultNegative() throws OperationNotSupported {
        assertEquals(num3 - num4, calculator.calculate(num3, num4, minus), 0.0);
        assertEquals(num4 - num3, calculator.calculate(num4, num3, minus), 0.0);
    }

    private char multiply = '*';

    @Test
    public void testCalculate_twoDoubleOperandMultiply_ResulttPositive() throws OperationNotSupported {
        assertEquals(num1 * num2, calculator.calculate(num1, num2, multiply), 0.0);
        assertEquals(num2 * num1, calculator.calculate(num2, num1, multiply), 0.0);
    }

    @Test
    public void testCalculate_twoDoubleOperandMiltiply_ResultNegative() throws OperationNotSupported {
        assertEquals(num3 * num4, calculator.calculate(num3, num4, multiply), 0.0);
        assertEquals(num4 * num3, calculator.calculate(num4, num3, multiply), 0.0);
    }

    private char division = '/';

    @Test
    public void testCalculate_twoDoubleOperandDivision_ResulttPositive() throws OperationNotSupported {
        assertEquals(num1 / num2, calculator.calculate(num1, num2, division), 0.0);
        assertEquals(num2 / num1, calculator.calculate(num2, num1, division), 0.0);
    }

    @Test
    public void testCalculate_twoDoubleOperandDivision_ResultNegative() throws OperationNotSupported {
        assertEquals(num3 / num4, calculator.calculate(num3, num4, division), 0.0);
        assertEquals(num4 / num3, calculator.calculate(num4, num3, division), 0.0);
    }

    @Test(expected = OperationNotSupported.class)
    public void testCalculate_ExceptionOperationNotFound() throws OperationNotSupported {
        calculator.calculate(num1, num2, '%');
    }

//    @Test(expected = NumberFormatException.class)
//    public void testCalculate_ExceptionNumberFormatException() throws OperationNotSupported {

//        List<String> content = Arrays.asList("a + 1");
//
//        ICalculator calculator = new CharCalculator();
//        LineProcessor processor = new LineProcessor(calculator);
//
//        List<String> result = processor.processLines(content);
//    }
}
