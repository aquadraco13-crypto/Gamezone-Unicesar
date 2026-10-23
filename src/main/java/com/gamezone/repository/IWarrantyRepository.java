package com.gamezone.repository;

import com.gamezone.model.Warranty;
import java.util.List;

/**
 * Repository interface for Warranty persistence.
 */
public interface IWarrantyRepository {
    void save(Warranty warranty);
    Warranty findById(String id);
    List<Warranty> findBySaleId(String saleId);
    List<Warranty> findByProductId(String productId);
    List<Warranty> findAll();
}