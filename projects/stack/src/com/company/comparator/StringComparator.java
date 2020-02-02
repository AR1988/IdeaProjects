package com.company.comparator;

public class StringComparator extends OurComparator {
    @Override
    public int compare(Object o1, Object o2) {
        String str1 = (String) o1;
        String str2 = (String) o2;

        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();

        int resStr1Char = 0;
        int resStr2Char = 0;

        for (char c : str1Char) {
            resStr1Char += c;
        }
        for (char c : str2Char) {
            resStr2Char += c;
        }

        return resStr1Char - resStr2Char;
    }
}
