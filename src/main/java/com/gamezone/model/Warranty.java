package com.gamezone.model;

import com.gamezone.exception.ValidationException;

/**
 * Represents a warranty for a product.
 * Validations ensure that only consoles can have extended warranties
 * and that warranty cost is non-negative.
 */
public class Warranty {
    private String id;
    private String productId;
    private String saleId;
    private boolean extended;
    private double cost;

    public Warranty(String id, String productId, String saleId, boolean extended, double cost) {
        if (productId == null || productId.isEmpty()) {
            throw new ValidationException("The product associated with the warranty can't be empty.");
        }
        if (saleId == null || saleId.isEmpty()) {
            throw new ValidationException("The sale associated with the warranty can't be empty.");
        }
        if (extended && !productId.startsWith("CONSOLE")) {
            throw new ValidationException("Only consoles can have an extended warranty.");
        }
        if (cost < 0) {
            throw new ValidationException("The cost of the warranty can't be negative.");
        }
        this.id = id;
        this.productId = productId;
        this.saleId = saleId;
        this.extended = extended;
        this.cost = cost;
    }

    public String getId() { return id; }
    public String getProductId() { return productId; }
    public String getSaleId() { return saleId; }
    public boolean isExtended() { return extended; }
    public double getCost() { return cost; }
}