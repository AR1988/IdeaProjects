package com.company;

public class ReverseCase {
    private String source;

    public ReverseCase(String source) {
        this.source = source;
    }

    public String charsCompare() {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i]))
                chars[i] = Character.toUpperCase(chars[i]);
            else chars[i] = Character.toLowerCase(chars[i]);
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < chars.length; i++) {
//            stringBuilder.append(chars[i]);
//        }
//        return stringBuilder.toString();
        return  new String(chars);
    }
}
