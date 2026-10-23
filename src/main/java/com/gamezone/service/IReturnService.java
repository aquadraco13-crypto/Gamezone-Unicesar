package com.gamezone.service;

import com.gamezone.model.Return;
import java.util.List;

public interface IReturnService {
    void processReturn(Return returnItem);
    List<Return> findAll();
}