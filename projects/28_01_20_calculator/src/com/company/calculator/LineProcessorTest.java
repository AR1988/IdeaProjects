package com.company.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LineProcessorTest {
    LineProcessor lp;
    ICalculator calculator;

    @Before
    public void init() {
        calculator = mock(ICalculator.class);
        lp = new LineProcessor(calculator);
    }

    @Test
    public void testProcessLine_legalOperationLegalFormat_result() throws OperationNotSupportedException {
        String inputString = "2.3,+,3.45";
        when(calculator.calculate(2.3, 3.45, '+')).thenReturn(5.75);
        assertEquals(inputString + ",5.75", lp.processLine(inputString));
    }

    @Test
    public void testProcessLine_IlegalOperationLegalFormat_result() throws OperationNotSupportedException {
        String line = "2.3,+,3.45";
        when(calculator.calculate(2.3, 3.45, '+')).thenThrow(OperationNotSupportedException.class);
        assertEquals(LineProcessor.AT_LINE_ERROR + line + LineProcessor.UNSUPPORTED_OPERAND_ERROR + LineProcessor.DELIMITER, lp.processLine(line));
    }

    @Test
    public void testProcessLine_legalOperationILegalFormatMum1_result() throws OperationNotSupportedException {
        String line = "a,+,3.45";
        assertEquals(LineProcessor.AT_LINE_ERROR + line + LineProcessor.UNSUPPORTED_INPUT_FORMAT_ERROR_NUM1, lp.processLine(line));
    }

    @Test
    public void testProcessLine_legalOperationILegalFormatMum2_result() throws OperationNotSupportedException {
        String line = "2.3,+,b";
        assertEquals(LineProcessor.AT_LINE_ERROR + line + LineProcessor.UNSUPPORTED_INPUT_FORMAT_ERROR_NUM2, lp.processLine(line));
    }

    @Test
    public void testProcessLine_legalOperationILegalFormatBothNum_result() throws OperationNotSupportedException {
        String line = "a,+,b";
        assertEquals(LineProcessor.AT_LINE_ERROR + line + LineProcessor.UNSUPPORTED_INPUT_FORMAT_ERROR_NUM1, lp.processLine(line));
    }

    @Test
    public void testProcessLine_IlegalFormat_result() throws OperationNotSupportedException {
        String line = "2.33.45";
        assertEquals(LineProcessor.AT_LINE_ERROR + line + LineProcessor.WRONG_INPUT_FORMAT_ERROR, lp.processLine(line));
    }

}