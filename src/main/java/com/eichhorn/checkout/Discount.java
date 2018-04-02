package com.eichhorn.checkout;

public class Discount {

    private int discountValue;
    private int quantityNeeded;

    public Discount(int discountValue, int quantityNeeded) {
        this.discountValue = discountValue;
        this.quantityNeeded = quantityNeeded;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }
}
