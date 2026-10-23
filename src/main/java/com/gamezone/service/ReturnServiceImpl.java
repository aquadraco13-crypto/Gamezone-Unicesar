package com.gamezone.service;

import com.gamezone.exception.ValidationException;
import com.gamezone.model.Return;
import com.gamezone.repository.IReturnRepository;
import java.util.List;

public class ReturnServiceImpl implements IReturnService {

    private final IReturnRepository returnRepository;

    public ReturnServiceImpl(IReturnRepository returnRepository) {
        if (returnRepository == null) {
            throw new ValidationException("ReturnRepository cannot be null.");
        }
        this.returnRepository = returnRepository;
    }

    @Override
    public void processReturn(Return returnItem) {
        if (returnItem == null) {
            throw new ValidationException("Return data cannot be null.");
        }
        returnRepository.save(returnItem);
    }

    @Override
    public List<Return> findAll() {
        return returnRepository.findAll();
    }
}