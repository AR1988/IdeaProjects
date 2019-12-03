package com.company.object;

public class Worker extends Employee {
    private static int idWorker = 1;

    public Worker(String name, String surName, int vacationUsed) {
        super(name, surName, vacationUsed);
    }

    public static int getIdWorker() {
        return idWorker++;
    }



    @Override
    public int vacationFree() {
        int vacationTotal = 28;
        return vacationTotal - getVacationUsed();
    }

    @Override
    public String toString() {
        return "id: " + getIdWorker() + "\t " + getName() + " " + getSurName() + "\tposition: " + getPosition() + "\t>> vacation used:\t " + getVacationUsed() + "\t vacation free: " + vacationFree();
    }
}
