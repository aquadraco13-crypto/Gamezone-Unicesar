package com.gamezone.repository;

import com.gamezone.model.Return;
import java.util.List;

public interface IReturnRepository {
    void save(Return returnItem);
    List<Return> findAll();
}