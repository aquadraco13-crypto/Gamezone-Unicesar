package com.gamezone.service;

import com.gamezone.model.Accessory;
import java.util.ArrayList;
import java.util.List;

public class AccessoryService {

    private final List<Accessory> accessories;

    public AccessoryService() {
        this.accessories = new ArrayList<>();
    }

    public AccessoryService(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public void addAccessory(Accessory accessory) {
        this.accessories.add(accessory);
    }

    public Accessory findById(String accessoryId) {
        for (Accessory accessory : accessories) {
            if (accessory.getId() != null && accessory.getId().equals(accessoryId)) {
                return accessory;
            }
        }
        return null;
    }

    /**
     * Restores the stock of a specific accessory when returned (A4).
     * 
     * @param accessoryId ID of the accessory
     * @param quantity Quantity to restore
     */
    public void restoreStock(String accessoryId, int quantity) {
        Accessory accessory = findById(accessoryId);
        if (accessory != null) {
            accessory.setStock(accessory.getStock() + quantity);
        }
    }
}