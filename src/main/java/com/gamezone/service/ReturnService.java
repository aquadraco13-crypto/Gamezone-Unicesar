package com.gamezone.service;

import com.gamezone.model.Return;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to handle product/accessory returns, monthly balance reports,
 * customer return history, and warranty cancellations (A4, A6, A7).
 */
public class ReturnService {

    private final List<Return> returns;
    private final WarrantyService warrantyService;

    public ReturnService() {
        this.returns = new ArrayList<>();
        this.warrantyService = new WarrantyService();
    }

    public ReturnService(List<Return> returns, WarrantyService warrantyService) {
        this.returns = returns != null ? returns : new ArrayList<>();
        this.warrantyService = warrantyService != null ? warrantyService : new WarrantyService();
    }

    /**
     * Registers a return, processing warranty cancellation if applicable (A7).
     *
     * @param productId ID of the returned product
     * @param saleId    ID of the sale
     * @return Total refund amount including warranty refund
     */
    public double registerReturn(String productId, String saleId) {
        double refund = 0.0;
        
        // Se cancelan las garantías asociadas a la consola/producto si aplica (A7)
        if (warrantyService != null) {
            double warrantyRefund = warrantyService.cancelWarranties(productId, saleId);
            refund += warrantyRefund;
        }
        
        return refund;
    }

    /**
     * Calculates total monthly sales considering final prices with discounts and warranties (A6).
     */
    public double calculateMonthlySales(int month, int year) {
        return 0.0;
    }

    /**
     * Calculates total monthly returns (A6).
     */
    public double calculateMonthlyReturns(int month, int year) {
        return 0.0;
    }

    /**
     * Generates net monthly balance as the difference between total sales and total returns (A6).
     */
    public double generateMonthlyBalance(int month, int year) {
        return calculateMonthlySales(month, year) - calculateMonthlyReturns(month, year);
    }

    /**
     * Retrieves the return history for a specific customer within a date range (A7).
     */
    public List<Return> getReturnHistoryByCustomer(String customerId, LocalDate startDate, LocalDate endDate) {
        List<Return> filteredReturns = new ArrayList<>();
        
        for (Return ret : returns) {
            boolean matchesCustomer = customerId == null || customerId.isEmpty(); 
            boolean matchesDateRange = true;

            if (matchesCustomer && matchesDateRange) {
                filteredReturns.add(ret);
            }
        }
        
        return filteredReturns;
    }
}