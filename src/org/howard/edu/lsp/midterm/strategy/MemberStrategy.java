package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy implementation for Member customers.
 * Applies a 10% discount to the base price.
 * * @author Samyak Baidya
 */
public class MemberStrategy implements PricingStrategy {
    /**
     * Calculates price for members by applying a 10% discount.
     * * @param price the original base price
     * @return the price after a 10% reduction
     */
    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}
