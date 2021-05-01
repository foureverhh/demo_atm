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

    public int getOneThousand(){
        return cashMapper.getOneThousand();
    }

    public int getFiveHundred(){
        return cashMapper.getFiveHundred();
    }

    public int getOneHundred(){
        return cashMapper.getOneHundred();
    }

    public int checkOneThousandBill(){
        return cashMapper.checkOneThousandBill();
    }

    public int checkFiveHundredBill(){
        return cashMapper.checkFiveHundredBill();
    }

    public int checkOneHundredBill(){
        return cashMapper.checkOneHundredBill();
    }

    public int checkBillAmount(int value){
        return cashMapper.checkBillAmount(value);
    }
}
