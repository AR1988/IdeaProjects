package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
        System.out.println(reverse2("hello"));
    }

    static String reverse(String str) {

        char[] chars = str.toCharArray();
        char[] strReverse = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            strReverse[i] = chars[str.length() - i - 1];
        }
        return new String(strReverse);
    }

    static String reverse2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
