package com.eichhorn.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {

    private PricingRules pricingRules;
    private Map<String, Integer> itemsMap = new HashMap<String, Integer>();

    public CheckOut(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

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

        /*for(int i = 0; i < itemsMap.size(); i++) {
            totalPrice += pricingRules.getPriceForItem(itemsMap.get(i));
        }*/

        return totalPrice;
    }
}
