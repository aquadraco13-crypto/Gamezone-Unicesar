package com.gamezone.service;

import com.gamezone.model.Sale;
import com.gamezone.repository.SaleRepository;
import java.util.List;

public class SaleService {
    private final SaleRepository saleRepository;
    private final List<Sale> sales;

    public SaleService() {
        this.saleRepository = new SaleRepository();
        this.sales = saleRepository.loadAll();
    }

    public void registerSale(Sale sale) {
        if (sale == null) {
            throw new IllegalArgumentException("La venta no puede ser nula");
        }
        sales.add(sale);
        saleRepository.saveAll(sales);
    }

    public Sale findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la venta no es válido");
        }
        return sales.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("La venta con identificador " + id + " no fue encontrada"));
    }

    public List<Sale> getAllSales() {
        return sales;
    }
}