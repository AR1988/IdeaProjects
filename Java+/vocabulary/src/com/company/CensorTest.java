package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CensorTest {

    @Test
    public void isLegal() {
        String[] text1 = {"text","unlegal","legalText"};
        String[] text2 = {"text","legal","legalText"};
        String[] text3 = {"unlegal","legal","legalText"};

        Censor censor1 = new Censor(text1);
        Censor censor2 = new Censor(text2);
        Censor censor3 = new Censor(text3);

        assertTrue(censor2.isLegal());
        assertFalse(censor1.isLegal());
        assertFalse(censor3.isLegal());
    }
}