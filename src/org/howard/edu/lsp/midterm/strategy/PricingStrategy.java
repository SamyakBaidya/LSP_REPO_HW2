package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface for defining a pricing strategy.
 */
public interface PricingStrategy {
    /**
     * Calculates the price based on a specific strategy.
     * @param price The original price.
     * @return The calculated final price.
     */
    double calculate(double price);
}