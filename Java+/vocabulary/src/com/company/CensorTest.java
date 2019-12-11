package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CensorTest {

    @Test
    public void isLegal() {
        String text1 = "text unlegal legalText";

        Censor censor1 = new Censor(new String[] {"unlegal"});
        Censor censor2 = new Censor(new String[] {"text","unlegal", "legalText"});
        Censor censor3 = new Censor(new String[] {"gtext","gunlegal", "glegalText"});

        assertFalse(censor1.isLegal(text1));
        assertFalse(censor2.isLegal(text1));
        assertTrue(censor3.isLegal(text1));
    }

    @Test
    public void isLegal_returns_false() {
        Censor censor = new Censor(new String[]{"Democracy", "Freedom"});
        String text = "democracy - the power of the people.";

        assertFalse(censor.isLegal(text));
    }

    @Test
    public void isLegal_returns_true() {
        Censor censor = new Censor(new String[]{"Democracy", "Freedom"});
        String text = "monarchy - the best system of government.";

        assertTrue(censor.isLegal(text));
    }
}