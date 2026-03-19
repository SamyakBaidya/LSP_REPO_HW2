package org.howard.edu.lsp.midterm.strategy;

/**
 * The Context class that maintains a reference to a PricingStrategy.
 * This class is responsible for delegating the calculation to the 
 * currently set strategy.
 * * @author Samyak Baidya
 */
public class PriceCalculator {
    private PricingStrategy strategy;

    /**
     * Updates the pricing strategy at runtime.
     * * @param strategy the new PricingStrategy to be used for calculations
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Executes the price calculation using the encapsulated strategy.
     * * @param price the base price to be processed
     * @return the final calculated price; returns original price if no strategy is set
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            return price;
        }
        return strategy.calculate(price);
    }
}
