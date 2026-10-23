package com.gamezone.service;

/**
 * Service to handle monthly balance reports (A6).
 */
public class ReturnService {

    /**
     * Calculates total monthly sales considering final prices with discounts and warranties (A6).
     * @param month
     * @param year
     * @return 
     */
    public double calculateMonthlySales(int month, int year) {
        // Retorna el cálculo de ventas mensuales
        return 0.0;
    }

    /**
     * Calculates total monthly returns (A6).
     * @param month
     * @param year
     * @return 
     */
    public double calculateMonthlyReturns(int month, int year) {
        // Retorna el cálculo de devoluciones mensuales
        return 0.0;
    }

    /**
     * Generates net monthly balance as the difference between total sales and total returns (A6).
     * @param month
     * @param year
     * @return 
     */
    public double generateMonthlyBalance(int month, int year) {
        return calculateMonthlySales(month, year) - calculateMonthlyReturns(month, year);
    }
}