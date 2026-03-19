package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to demonstrate the Strategy Pattern implementation.
 */
public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double basePrice = 100.0;

        // REGULAR
        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(basePrice));

        // MEMBER
        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(basePrice));

        // VIP
        calculator.setStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(basePrice));

        // HOLIDAY
        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(basePrice));
    }
}