package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for Holiday promotions (15% discount).
 */
public class HolidayStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.85;
    }
}