package com.eichhorn.checkout;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CheckOutTest {

    private int price(String items) {
        return 0;
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

    }
}
