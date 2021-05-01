package com.example.demo_atm.service;

import com.example.demo_atm.mapper.CashMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashService {
    @Autowired
    private CashMapper cashMapper;

    public int findAllValue(){
        return cashMapper.findAllValue();
    }
}
