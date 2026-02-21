package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Main driver to run the ETL pipeline with Assignment 2 behavior.
 * Prints required run summary.
 */
public class ETLPipeline {

    /**
     * Program entry point.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        final String inputPath = "data/products.csv";
        final String outputPath = "data/transformed_products.csv";

        DataLoader loader = new DataLoader();
        DataTransformer transformer = new DataTransformer();
        DataWriter writer = new DataWriter();

        DataLoader.LoadResult loadResult;
        try {
            loadResult = loader.loadProducts(inputPath);
        } catch (IOException e) {
            // Missing input file or unreadable file — must be clear and no stack trace
            System.err.println("ERROR: Missing or unreadable input file: " + inputPath);
            return;
        }

        List<Product> products = loadResult.getProducts();

        // Transform
        transformer.transform(products);

        // Load (always create output file with header even if empty)
        try {
            writer.write(products, outputPath);
        } catch (IOException e) {
            System.err.println("ERROR: Could not write output file: " + outputPath);
            return;
        }

        // Run summary
        int rowsRead = loadResult.getRowsRead();
        int rowsSkipped = loadResult.getRowsSkipped();
        int rowsTransformed = products.size();

        System.out.println("Run Summary");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}