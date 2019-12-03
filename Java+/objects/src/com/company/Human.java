package com.company;

public class Human {
    public Human() {

    }

    Human(String nameId, String surnameID, int ageId) {
        name = nameId;
        surname = surnameID;
        age = ageId;
    }

    String name;
    String surname;
    int age;



    void output() {
        System.out.println("My name is " + name + ", my surname is " + surname + ". I am " + age + ".");
    }
}
