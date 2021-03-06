package com.eichhorn.checkout;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CheckOutTest {

    private int price(String items) {
        CheckOut checkOut = new CheckOut(rules());

        for(int i = 0; i < items.length(); i++) {
            checkOut.scan(items.substring(i, i+1));
        }

        return checkOut.total();
    }

    private PricingRules rules() {
        PricingRules pricingRules = new PricingRules();

        pricingRules.addPricingRule("A", 50);
        pricingRules.addPricingRule("B", 30);
        pricingRules.addPricingRule("C", 20);
        pricingRules.addPricingRule("D", 15);

        pricingRules.addDiscountRule("A", new Discount(20, 3));
        pricingRules.addDiscountRule("B", new Discount(15, 2));

        return pricingRules;
    }

    @Test
    public void testTotals() {
        assertEquals(0, price(""));
        assertEquals(50, price("A"));
        assertEquals(80, price("AB"));
        assertEquals(115, price("CDBA"));

        assertEquals(100, price("AA"));
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
        assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));

        assertEquals(160, price("AAAB"));
        assertEquals(175, price("AAABB"));
        assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }

    @Test
    public void testIncremental() {
        CheckOut checkOut = new CheckOut(rules());

        assertEquals(0, checkOut.total());

        checkOut.scan("A");
        assertEquals(50, checkOut.total());

        checkOut.scan("B");
        assertEquals(80, checkOut.total());

        checkOut.scan("A");
        assertEquals(130, checkOut.total());

        checkOut.scan("A");
        assertEquals(160, checkOut.total());

        checkOut.scan("B");
        assertEquals(175, checkOut.total());
    }
}
