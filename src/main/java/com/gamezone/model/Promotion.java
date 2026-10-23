package com.gamezone.model;

import com.gamezone.exception.ValidationException;

/**
 * Represents a promotion applied to a sale.
 */
public class Promotion {
    private String id;
    private String name;
    private String category; // VIDEOGAME, CONSOLE, ACCESSORY
    private double discountPercentage;

    public Promotion(String id, String name, String category, double discountPercentage) {
        if (!category.equals("VIDEOGAME") && 
            !category.equals("CONSOLE") && 
            !category.equals("ACCESSORY")) {
            throw new ValidationException("Categoría inválida para la promoción.");
        }
        if (discountPercentage <= 0 || discountPercentage > 100) {
            throw new ValidationException("El porcentaje de descuento debe estar entre 1 y 100.");
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.discountPercentage = discountPercentage;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getDiscountPercentage() { return discountPercentage; }
}