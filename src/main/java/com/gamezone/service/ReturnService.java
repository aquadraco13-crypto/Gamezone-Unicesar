package com.gamezone.service;

import com.gamezone.model.Accessory;

/**
 * Service to handle product and accessory returns (A4).
 */
public class ReturnService {

    private final AccessoryService accessoryService; // Atributo para accesorios (A4)

    /**
     * Constructor receiving AccessoryService for stock restoration (A4).
     * 
     * @param accessoryService Service for accessory operations
     */
    public ReturnService(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    /**
     * Restores stock depending on whether the returned item is an Accessory (A4).
     * 
     * @param item Item being returned
     * @param itemId ID of the item
     * @param quantity Quantity to restore
     */
    public void processStockRestoration(Object item, String itemId, int quantity) {
        if (item instanceof Accessory) {
            accessoryService.restoreStock(itemId, quantity);
        }
    }
}