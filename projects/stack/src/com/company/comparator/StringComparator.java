package com.company.comparator;

public class StringComparator implements OurComparator {
    @Override
    public int compare(Object o1, Object o2) {
        String str1 = (String) o1;
        String str2 = (String) o2;

        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();

        int resStr1Char = 0;
        int resStr2Char = 0;

        for (int i = 0; i < str1Char.length; i++) {
            resStr1Char += (int) str1Char[i];
        }
        for (int i = 0; i < str2Char.length; i++) {
            resStr2Char = (int) str2Char[i];
        }

        return resStr1Char - resStr2Char;
    }
}
