package com.gamezone.model;

import com.gamezone.exception.ValidationException;
import java.util.List;
import java.time.LocalDate;

/**
 * Represents a sale transaction.
 */
public class Sale {
    private String id;
    private List<String> itemIds;
    private double subtotal;
    private double discount;
    private double warrantyCost;
    private double total;
    private LocalDate saleDate; // new attribute

    public Sale(String id, List<String> itemIds, double subtotal) {
        if (itemIds == null || itemIds.isEmpty()) {
            throw new ValidationException("The sale must include at least one product or accessory.");
        }
        if (subtotal <= 0) {
            throw new ValidationException("The sale subtotal must be positive.");
        }
        this.id = id;
        this.itemIds = itemIds;
        this.subtotal = subtotal;
        this.discount = 0.0;
        this.warrantyCost = 0.0;
        this.total = subtotal;
        this.saleDate = LocalDate.now(); // initialization
    }

    public String getId() { return id; }
    public List<String> getItemIds() { return itemIds; }
    public double getSubtotal() { return subtotal; }
    public double getDiscount() { return discount; }
    public double getWarrantyCost() { return warrantyCost; }
    public double getTotal() { return total; }
    public LocalDate getSaleDate() { return saleDate; }
}