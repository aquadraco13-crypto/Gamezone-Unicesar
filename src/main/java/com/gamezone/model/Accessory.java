package com.gamezone.model;

/**
 * Represents an accessory in the store.
 */
public class Accessory {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Accessory(String id, String name, double price, int stock) {
        if (price <= 0) {
            throw new IllegalArgumentException("the price of the accessory must be positive.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("The accessory stock cannot be negative.");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock del accesorio no puede ser negativo.");
        }
        this.stock = stock;
    }
}
