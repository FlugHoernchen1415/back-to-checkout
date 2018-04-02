package com.eichhorn.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {

    private Map<String, Integer> normalPricingMap = new HashMap<String, Integer>();
    private Map<String, Discount> discountPricingMap = new HashMap<String, Discount>();

    public void addPricingRule(String item, int price) {
        normalPricingMap.put(item, price);
    }

    public void addDiscountRule(String item, Discount discount) {
        discountPricingMap.put(item, discount);
    }

    public int getPriceForItem(String item, int quantity) {

        int totalPrice = normalPricingMap.get(item) * quantity;

        if(discountPricingMap.containsKey(item)
                && quantity / discountPricingMap.get(item).getQuantityNeeded() >= 1) {
            totalPrice -= quantity / discountPricingMap.get(item).getQuantityNeeded() * discountPricingMap.get(item).getDiscountValue();
        }

        return totalPrice;
    }
}
