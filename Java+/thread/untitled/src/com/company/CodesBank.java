package com.company;

public class CodesBank {
    String code;
    String name;

    public CodesBank(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Start: " + code + " " + name + "\t";
    }
}