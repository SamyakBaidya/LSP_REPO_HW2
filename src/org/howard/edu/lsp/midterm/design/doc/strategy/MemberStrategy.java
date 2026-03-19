package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for Member customers (10% discount).
 */
public class MemberStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}