package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Extract step: reads products from CSV using the Assignment 2 rules.
 * Also applies row-skipping rules and counts rows read/skipped.
 */
public class DataLoader {

    /**
     * Result of loading: parsed products + counts required for run summary.
     */
    public static class LoadResult {
        private final List<Product> products;
        private final int rowsRead;    // non-header lines encountered (including bad)
        private final int rowsSkipped; // bad/blank/malformed lines skipped

        /**
         * Constructs a load result.
         *
         * @param products list of successfully parsed products
         * @param rowsRead number of non-header lines encountered
         * @param rowsSkipped number of skipped rows
         */
        public LoadResult(List<Product> products, int rowsRead, int rowsSkipped) {
            this.products = products;
            this.rowsRead = rowsRead;
            this.rowsSkipped = rowsSkipped;
        }

        /** @return parsed products */
        public List<Product> getProducts() {
            return products;
        }

        /** @return rows read (non-header lines encountered) */
        public int getRowsRead() {
            return rowsRead;
        }

        /** @return rows skipped */
        public int getRowsSkipped() {
            return rowsSkipped;
        }
    }

    /**
     * Loads products from data/products.csv.
     * Skips any non-header row that is blank, not exactly 4 fields, or has unparseable ID/Price.
     * Does not crash on bad rows.
     *
     * @param filePath relative path to input CSV
     * @return LoadResult containing products and counts
     * @throws IOException if file cannot be opened/read
     */
    public LoadResult loadProducts(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        int rowsRead = 0;
        int rowsSkipped = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // header row
            if (header == null) {
                // Completely empty file (no header) — treat like "header only" for safety
                return new LoadResult(products, 0, 0);
            }

            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",", -1); // keep empties
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String idStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                int productId;
                try {
                    productId = Integer.parseInt(idStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                BigDecimal price;
                try {
                    price = new BigDecimal(priceStr);
                } catch (Exception e) {
                    rowsSkipped++;
                    continue;
                }

                // originalCategory is the trimmed category BEFORE any transform
                products.add(new Product(productId, name, price, category, category));
            }
        }

        return new LoadResult(products, rowsRead, rowsSkipped);
    }
}