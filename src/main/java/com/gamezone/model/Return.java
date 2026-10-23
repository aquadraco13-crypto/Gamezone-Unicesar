package com.gamezone.model;

import com.gamezone.exception.ValidationException;
import java.util.List;

public class Return {
    private String id;
    private String saleId;
    private List<String> itemIds;
    private double refundAmount;

    public Return(String id, String saleId, List<String> itemIds, double refundAmount) {
        if (itemIds == null || itemIds.isEmpty()) {
            throw new ValidationException("La devolución debe incluir al menos un ítem.");
        }
        if (refundAmount < 0) {
            throw new ValidationException("El monto de reembolso no puede ser negativo.");
        }
        this.id = id;
        this.saleId = saleId;
        this.itemIds = itemIds;
        this.refundAmount = refundAmount;
    }

    public String getId() { return id; }
    public String getSaleId() { return saleId; }
    public List<String> getItemIds() { return itemIds; }
    public double getRefundAmount() { return refundAmount; }

    public void setRefundAmount(double refundAmount) {
        if (refundAmount < 0) {
            throw new ValidationException("El monto de reembolso no puede ser negativo.");
        }
        this.refundAmount = refundAmount;
    }

    /**
     * Validates that the returned item belongs to the original sale.
     */
    public void validateItemBelongsToSale(String itemId, List<String> originalSaleItems) {
        if (!originalSaleItems.contains(itemId)) {
            throw new ValidationException("El ítem no pertenece a la venta original.");
        }
    }
}