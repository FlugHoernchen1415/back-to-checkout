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

    /**
     * Calculates the total price for a specific item.
     * If an Item is present in the discountPricingMap, then another Method is called to check if the discount
     * condition applies for the Item and the given quantity.
     *
     * @param item A specific Item
     * @param quantity How often the Item is present. Is necessary to determine if a discount could be granted
     * @return The price for a specific Item, eventually with a discount
     */
    public int getPriceForItem(String item, int quantity) {

        int totalPrice = normalPricingMap.get(item) * quantity;

        if(discountPricingMap.containsKey(item)) {
            totalPrice -= discountPricingMap.get(item).calculateDiscount(quantity);
        }

        return totalPrice;
    }
}
