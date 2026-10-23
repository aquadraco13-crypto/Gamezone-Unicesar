package com.gamezone.service;

import com.gamezone.exception.ValidationException;
import com.gamezone.model.Warranty;
import com.gamezone.repository.IWarrantyRepository;
import java.util.List;

public class WarrantyServiceImpl implements IWarrantyService {

    private final IWarrantyRepository warrantyRepository;

    public WarrantyServiceImpl(IWarrantyRepository warrantyRepository) {
        if (warrantyRepository == null) {
            throw new ValidationException("WarrantyRepository cannot be null.");
        }
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public void processWarranty(Warranty warranty) {
        if (warranty == null) {
            throw new ValidationException("Warranty data cannot be null.");
        }
        warrantyRepository.save(warranty);
    }

    @Override
    public List<Warranty> findAll() {
        return warrantyRepository.findAll();
    }
}