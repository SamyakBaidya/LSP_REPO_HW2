package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Transform step: applies Assignment 2 transformation rules in the exact required order.
 */
public class DataTransformer {

    private static final BigDecimal TEN = new BigDecimal("10.00");
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100.00");
    private static final BigDecimal FIVE_HUNDRED = new BigDecimal("500.00");
    private static final BigDecimal DISCOUNT_FACTOR = new BigDecimal("0.9");

    /**
     * Applies transformations in this exact order:
     * 1) Name -> UPPERCASE
     * 2) If original category is Electronics, apply 10% discount
     * 3) If final rounded price > 500 AND original category was Electronics, category -> Premium Electronics
     * 4) Compute PriceRange from final rounded price
     *
     * @param products list of products to transform
     */
    public void transform(List<Product> products) {
        for (Product p : products) {

            // 1) Uppercase name
            p.setName(p.getName().toUpperCase());

            boolean originalIsElectronics = "Electronics".equals(p.getOriginalCategory());

            // 2) Electronics discount (based on original category)
            if (originalIsElectronics) {
                BigDecimal discounted = p.getPrice().multiply(DISCOUNT_FACTOR);
                p.setPrice(discounted);
                // Keep category as "Electronics" (exact) unless later rule changes it
                p.setCategory("Electronics");
            }

            // Round price to 2 decimals using round-half-up (required)
            BigDecimal finalRounded = p.getPrice().setScale(2, RoundingMode.HALF_UP);
            p.setPrice(finalRounded);

            // 3) Premium Electronics rule (uses final rounded price + original category)
            if (originalIsElectronics && finalRounded.compareTo(FIVE_HUNDRED) > 0) {
                p.setCategory("Premium Electronics");
            }

            // 4) PriceRange based on final rounded price
            p.setPriceRange(computePriceRange(finalRounded));
        }
    }

    /**
     * Computes PriceRange from final rounded price.
     *
     * @param price final rounded price
     * @return Low/Medium/High/Premium
     */
    public String computePriceRange(BigDecimal price) {
        if (price.compareTo(TEN) <= 0) {
            return "Low";
        }
        if (price.compareTo(ONE_HUNDRED) <= 0) {
            return "Medium";
        }
        if (price.compareTo(FIVE_HUNDRED) <= 0) {
            return "High";
        }
        return "Premium";
    }
}