package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy implementation for VIP customers.
 * Applies a 20% discount to the base price.
 * * @author Samyak Baidya
 */
public class VIPStrategy implements PricingStrategy {
    /**
     * Calculates price for VIPs by applying a 20% discount.
     * * @param price the original base price
     * @return the price after a 20% reduction
     */
    @Override
    public double calculate(double price) {
        return price * 0.80;
    }
}
