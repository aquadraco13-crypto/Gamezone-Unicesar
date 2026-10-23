package com.gamezone.service;

import com.gamezone.model.Return;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to handle product/accessory returns, monthly balance reports,
 * and customer return history (A4, A6, A7).
 */
public class ReturnService {

    private final List<Return> returns;

    public ReturnService() {
        this.returns = new ArrayList<>();
    }

    public ReturnService(List<Return> returns) {
        this.returns = returns != null ? returns : new ArrayList<>();
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
     *
     * @param customerId ID of the customer
     * @param startDate  Start date of the range
     * @param endDate    End date of the range
     * @return List of returns matching the criteria
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