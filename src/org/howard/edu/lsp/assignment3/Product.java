package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents one product row from the CSV plus derived fields after transformation.
 * Demonstrates encapsulation via private fields and public accessors.
 */
public class Product {
    private int productId;
    private String name;
    private BigDecimal price;         // final rounded price after transforms
    private String category;          // final category after transforms
    private String originalCategory;  // trimmed original category before transforms
    private String priceRange;        // derived from final rounded price

    /**
     * Constructs a Product using raw input fields (already trimmed where appropriate).
     *
     * @param productId        product id
     * @param name             product name
     * @param price            product price (unrounded/raw is OK; transformer will round)
     * @param category         product category (trimmed)
     * @param originalCategory original category (trimmed)
     */
    public Product(int productId, String name, BigDecimal price, String category, String originalCategory) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.originalCategory = originalCategory;
        this.priceRange = "";
    }

    /** @return product id */
    public int getProductId() {
        return productId;
    }

    /** @param productId new product id */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /** @return product name */
    public String getName() {
        return name;
    }

    /** @param name new product name */
    public void setName(String name) {
        this.name = name;
    }

    /** @return product price (final rounded after transform) */
    public BigDecimal getPrice() {
        return price;
    }

    /** @param price new product price */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /** @return product category (final after transform) */
    public String getCategory() {
        return category;
    }

    /** @param category new product category */
    public void setCategory(String category) {
        this.category = category;
    }

    /** @return original trimmed category before transform */
    public String getOriginalCategory() {
        return originalCategory;
    }

    /** @param originalCategory original category */
    public void setOriginalCategory(String originalCategory) {
        this.originalCategory = originalCategory;
    }

    /** @return derived price range */
    public String getPriceRange() {
        return priceRange;
    }

    /** @param priceRange derived price range */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}