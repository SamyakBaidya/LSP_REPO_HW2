package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy implementation for Holiday sales.
 * Applies a 15% discount to the base price.
 * * @author Samyak Baidya
 */
public class HolidayStrategy implements PricingStrategy {
    /**
     * Calculates price during holiday periods by applying a 15% discount.
     * * @param price the original base price
     * @return the price after a 15% reduction
     */
    @Override
    public double calculate(double price) {
        return price * 0.85;
    }
}
