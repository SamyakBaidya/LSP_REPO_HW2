package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface defining the contract for various pricing algorithms.
 * This represents the "Strategy" in the Strategy Design Pattern.
 * * @author Samyak Baidya
 */
public interface PricingStrategy {
    /**
     * Calculates the final price for a given base price based on a specific strategy.
     * * @param price the original base price of the item
     * @return the calculated final price after applying strategy-specific logic
     */
    double calculate(double price);
}
