package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Load step: writes transformed products to CSV with the exact required header and column order.
 */
public class DataWriter {

    /**
     * Writes output to data/transformed_products.csv.
     * Always writes the header row even if there are zero products.
     *
     * Output columns:
     * ProductID,Name,Price,Category,PriceRange
     *
     * @param products transformed products
     * @param filePath relative output path
     * @throws IOException if writing fails
     */
    public void write(List<Product> products, String filePath) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("ProductID,Name,Price,Category,PriceRange");
            for (Product p : products) {
                pw.printf("%d,%s,%.2f,%s,%s%n",
                        p.getProductId(),
                        p.getName(),
                        p.getPrice().doubleValue(),
                        p.getCategory(),
                        p.getPriceRange());
            }
        }
    }
}