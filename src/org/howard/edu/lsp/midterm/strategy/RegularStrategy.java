package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy implementation for Regular customers.
 * Provides no discount (1.0 x price).
 * * @author Samyak Baidya
 */
public class RegularStrategy implements PricingStrategy {
    /**
     * Returns the original price as no discount is applied for regular customers.
     * * @param price the original base price
     * @return the same price as the input
     */
    @Override
    public double calculate(double price) {
        return price;
    }
}
