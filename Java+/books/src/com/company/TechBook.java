package com.company;

public class TechBook extends Book {

    public TechBook(int id, String title, String author, int price, String scienceField) {
        super(id, title, author, price);
        this.scienceField = scienceField;
    }

    private String scienceField;

    @Override
    public String toString() {
        return super.toString()
                + " relates to the science of " + scienceField
                ;
    }
}
