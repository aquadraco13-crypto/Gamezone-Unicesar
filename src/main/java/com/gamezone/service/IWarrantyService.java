package com.gamezone.service;

import com.gamezone.model.Warranty;
import java.util.List;

public interface IWarrantyService {
    void processWarranty(Warranty warranty);
    List<Warranty> findAll();
}