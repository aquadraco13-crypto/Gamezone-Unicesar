package com.gamezone.repository;

import com.gamezone.model.Warranty;
import java.util.List;

public interface IWarrantyRepository {
    void save(Warranty warranty);
    List<Warranty> findAll();
}