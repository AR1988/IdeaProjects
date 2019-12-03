package com.company.object;

abstract public class Employee {
    private String name;
    private String surName;

    private int vacationUsed;
    private static int id = 1;

    Employee(String name, String surName, int vacationUsed) {
        this.name = name;
        this.surName = surName;
        this.vacationUsed = vacationUsed;
    }


    public int getId() {
        return id++;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }


    public int getVacationUsed() {
        return vacationUsed;
    }
    public String getPosition() {
        String pos = getClass().getSimpleName();
//        return "Worker";
        return pos;
    }
    @Override
    abstract public String toString();



    public abstract int vacationFree();
}
