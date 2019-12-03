package com.company;

public class BestSellerBook extends LiteratureBook {
    private double coef;

    public BestSellerBook(int id, String title, String author, int price, double coef) {
        super(id, title, author, price);
        this.coef = coef;
    }

    @Override
    public int computePrice() {
        return (int) (super.computePrice() * coef);
    }

    public double getCoef() {
        return coef;
    }
}
