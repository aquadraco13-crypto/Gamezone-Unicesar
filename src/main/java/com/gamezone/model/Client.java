package com.gamezone.model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private String email;
    private List<String> purchaseHistory;

    public Client(String name, String id, String phone, String email) {
        super(name, id, phone);
        this.email = email;
        this.purchaseHistory = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<String> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public void addPurchase(String purchaseRecord) {
        this.purchaseHistory.add(purchaseRecord);
    }

    @Override
    public String getRoleDetails() {
        return "Role: Client | Email: " + email + " | Purchases: " + purchaseHistory.size();
    }
}