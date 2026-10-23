package com.gamezone.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to handle console and product warranties and cancellation on returns (A7).
 */
public class WarrantyService {

    public WarrantyService() {
    }

    /**
     * Cancels warranties for a specific product in a given sale, 
     * removing them and returning the refundable cost (A7).
     *
     * @param productId ID of the product/console being returned
     * @param saleId    ID of the sale
     * @return Refundable cost of the cancelled warranties
     */
    public double cancelWarranties(String productId, String saleId) {
        double refundedAmount = 0.0;
        // Lógica de anulación de garantías extendidas
        return refundedAmount;
    }
}