package com.gamezone.service;

import com.gamezone.model.Warranty;
import com.gamezone.repository.IWarrantyRepository;
import com.gamezone.repository.ISaleRepository; // O el nombre de tu repositorio de ventas
import java.util.List;

/**
 * Service layer for managing warranties.
 * Receives WarrantyRepository, SaleRepository, and ProductService via constructor (A2).
 */
public class WarrantyService {
    private final IWarrantyRepository warrantyRepository;
    private final ISaleRepository saleRepository;
    private final ProductService productService;

    public WarrantyService(IWarrantyRepository warrantyRepository, 
                           ISaleRepository saleRepository, 
                           ProductService productService) {
        this.warrantyRepository = warrantyRepository;
        this.saleRepository = saleRepository;
        this.productService = productService;
    }

    public void registerWarranty(Warranty warranty) {
        // Validaciones o lógica para registrar la garantía
        warrantyRepository.save(warranty);
    }

    public List<Warranty> getAllWarranties() {
        return warrantyRepository.findAll();
    }
}