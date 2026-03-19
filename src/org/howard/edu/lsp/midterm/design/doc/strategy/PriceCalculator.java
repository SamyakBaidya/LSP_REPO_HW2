package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a PricingStrategy to calculate the final price.
 */
public class PriceCalculator {
    private PricingStrategy strategy;

    /**
     * Sets the current pricing strategy.
     * @param strategy The strategy to be used for calculation.
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the assigned strategy.
     * @param price The original price.
     * @return The discounted price.
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            return price; // Default behavior
        }
        return strategy.calculate(price);
    }
}