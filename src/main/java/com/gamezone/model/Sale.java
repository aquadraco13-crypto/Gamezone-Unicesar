package com.gamezone.model;

import java.util.List;
import java.time.LocalDate;
import com.gamezone.exceptions.EmptySaleException;
import com.gamezone.exceptions.ExpiredReturnException;

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
            throw new EmptySaleException("The sale must include at least one product or accessory.");
        }
        if (subtotal <= 0) {
            throw new IllegalArgumentException("The sale subtotal must be positive.");
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

    public void applyDiscount(double discount) {
        if (discount < 0) {
            throw new IllegalArgumentException("The discount can't be negative.");
        }
        this.discount = discount;
        recalculateTotal();
    }

    public void addWarrantyCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("The cost of the warranty can't be negative.");
        }
        this.warrantyCost += cost;
        recalculateTotal();
    }

    private void recalculateTotal() {
        this.total = subtotal - discount + warrantyCost;
    }

    public boolean canBeReturned() {
        if (saleDate.plusDays(30).isBefore(LocalDate.now())) {
            throw new ExpiredReturnException("La venta ya no puede ser devuelta (plazo vencido).");
        }
        return true;
    }
}
