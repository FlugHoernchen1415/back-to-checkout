package com.eichhorn.checkout;

import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    private PricingRules pricingRules;
    private List<String> itemList = new ArrayList<String>();

    public CheckOut(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(String item) {
        itemList.add(item);
    }

    public int total() {
        int totalPrice = 0;

        for(int i = 0; i < itemList.size(); i++) {
            totalPrice += pricingRules.getPriceForItem(itemList.get(i));
        }

        return totalPrice;
    }
}
