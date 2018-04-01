package com.eichhorn.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {

    private Map<String, Integer> normalPricingMap = new HashMap<String, Integer>();
    private Map<String, Discount> discountPricingMap = new HashMap<String, Discount>();

    public void addPricingRule(String item, int price) {
        normalPricingMap.put(item, price);
    }

    public void addDiscountRule() {

    }

    public int getPriceForItem(String item) {
        /*
            Next Steps for multi pricing strategy
                1. implement addDiscountRule() Method
                2. when fetching the price for an item
                    a) check if the given item is present in the discountPricingMap
                    b) if given item is present, then check if the condition for the discount does apply
                    c) return or subtract the discount value
                    d) else return normal price
        */

        return normalPricingMap.get(item);
    }
}
