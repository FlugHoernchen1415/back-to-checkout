package com.eichhorn.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {

    private Map<String, Integer> normalPricingMap = new HashMap<String, Integer>();
    private Map<String, Discount> discountPricingMap = new HashMap<String, Discount>();

    public void addPricingRule(String item, int price) {
        normalPricingMap.put(item, price);
    }

    public int getPriceForItem(String item) {
        return normalPricingMap.get(item);
    }
}
