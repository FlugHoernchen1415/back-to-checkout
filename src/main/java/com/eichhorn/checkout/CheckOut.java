package com.eichhorn.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {

    private PricingRules pricingRules;
    private Map<String, Integer> itemsMap = new HashMap<String, Integer>();

    public CheckOut(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    /**
     * Adds an Item to an itemMap, which contains all Items and their quantity.
     * If an Item is already present, then the amount of the Item is increased by one,
     * otherwise the Item is added as a new Item to the itemMap with an amount of one.
     *
     * @param item Item which should be added
     */
    public void scan(String item) {
        if(!itemsMap.containsKey(item)) {
            itemsMap.put(item, 1);
        } else {
            itemsMap.put(item, itemsMap.get(item) + 1);
        }
    }

    public int total() {
        int totalPrice = 0;

        for(Map.Entry<String, Integer> entry : itemsMap.entrySet()) {
            totalPrice += pricingRules.getPriceForItem(entry.getKey(), entry.getValue());
        }

        return totalPrice;
    }
}
