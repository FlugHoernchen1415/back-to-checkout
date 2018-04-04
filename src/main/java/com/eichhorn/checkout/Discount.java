package com.eichhorn.checkout;

public class Discount {

    private int discountValue;
    private int quantityNeeded;

    public Discount(int discountValue, int quantityNeeded) {
        this.discountValue = discountValue;
        this.quantityNeeded = quantityNeeded;
    }

    public int calculateDiscount(int quantity) {
        if(quantity / this.quantityNeeded >= 1) {
            return quantity / this.quantityNeeded * this.discountValue;
        }
        return 0;
    }
}
