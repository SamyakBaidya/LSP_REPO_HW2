/**
 * Name: Samyak Baidya
 */
package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputFilePath);
        File outputDir = new File("data");

        // Requirement: Handle missing input file gracefully
        if (!inputFile.exists()) {
            System.err.println("Error: Input file 'data/products.csv' not found.");
            return;
        }

        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            // Process Header
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                writer.println("ProductID,Name,Price,Category,PriceRange");
            }

            // Process Data Rows
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    rowsRead++;
                    continue;
                }

                rowsRead++;
                String[] fields = line.split(",");

                // Requirement: Skip rows without exactly 4 fields
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    String priceStr = fields[2].trim();
                    String category = fields[3].trim();

                    // Requirement: Validate ProductID and Price can be parsed
                    Integer.parseInt(id); 
                    BigDecimal price = new BigDecimal(priceStr);

                    // 1. Transform Name to Uppercase
                    name = name.toUpperCase();

                    // 2. Apply 10% Discount to Electronics
                    if (category.equalsIgnoreCase("Electronics")) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // Round price to 2 decimal places (Round Half Up)
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // 3. Change to Premium Electronics if > $500 and originally Electronics
                    if (category.equalsIgnoreCase("Electronics") && price.compareTo(new BigDecimal("500.00")) > 0) {
                        category = "Premium Electronics";
                    }

                    // 4. Determine PriceRange
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    // Write to CSV
                    writer.printf("%s,%s,%.2f,%s,%s%n", id, name, price, category, priceRange);
                    rowsTransformed++;

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

            // Print Run Summary
            System.out.println("Execution Summary:");
            System.out.println("Number of rows read: " + rowsRead);
            System.out.println("Number of rows transformed: " + rowsTransformed);
            System.out.println("Number of rows skipped: " + rowsSkipped);
            System.out.println("Output file path: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("An error occurred during file processing.");
        }
    }
}