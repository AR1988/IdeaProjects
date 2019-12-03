package com.company.object;

public class Manager extends Employee {
    private static int idManager = 1;

    public Manager(String name, String surName, int vacationUsed) {
        super(name, surName, vacationUsed);
    }

    public static int getIdManager() {
        return idManager;
    }

    @Override
    public int vacationFree() {
        int vacationTotal = 32;
        return vacationTotal - getVacationUsed();
    }

    @Override
    public String toString() {
        return "id: " + getIdManager() + "\t " + getName() + " " + getSurName() + "\tposition: " + getPosition() + "\t>> vacation used:\t " + getVacationUsed() + "\t vacation free: " + vacationFree();
    }
}
