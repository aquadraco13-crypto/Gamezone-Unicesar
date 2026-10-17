package com.gamezone.model;


public class Seller extends Person {

    private String employeeId;
    private double totalSales;

    public Seller(String name, String id, String phone, String employeeId) {
        super(name, id, phone);
        this.employeeId = employeeId;
        this.totalSales = 0.0;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public void recordSale(double amount) {
        if (amount > 0) {
            this.totalSales += amount;
        }
    }

    @Override
    public String getRoleDetails() {
        return "Role: Seller | Employee ID: " + employeeId + " | Total Sales: $" + totalSales;
    }
}