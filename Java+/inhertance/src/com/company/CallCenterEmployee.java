package com.company;

public class CallCenterEmployee extends Employee {

    private int monthlyHours;

    private CallCenterEmployee(int id, String name, String companyName, int basicSalary, int monthlyHours) {
        super(id, name, companyName, basicSalary);
        this.monthlyHours = monthlyHours;
    }

    @Override
    int getMonthlySalary() {
        return 0;
    }
}
