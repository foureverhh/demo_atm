package com.example.demo_atm.service;

import com.example.demo_atm.mapper.CashMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CashService {
    @Autowired
    private CashMapper cashMapper;

    public int findAllValue(){
        return cashMapper.findAllValue();
    }

    public int getOneThousand(int amount){
        return cashMapper.getOneThousand(amount);
    }

    public int getFiveHundred(int amount){
        return cashMapper.getFiveHundred(amount);
    }

    public int getOneHundred(int amount){
        return cashMapper.getOneHundred(amount);
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

    public int getBill(int value,int amount){
        return cashMapper.getBill(value,amount);
    }

    public int withdraw(int value) {
        int counter = 0;
        Map<Integer,Integer> cash_map = new HashMap<>();
        if(value == 0)
            return 0;

        if(value > findAllValue())
            return -1;

        if(value / 1000 >0) {
            counter = Math.min(checkBillAmount(1000),value / 1000);
            value = value - 1000 * counter;
            cash_map.put(1000,counter);
        }

        if(value / 500 >0){
            counter = Math.min(checkBillAmount(500),value / 500);
            value = value - 500 * counter;
            cash_map.put(500,counter);
        }

        if(value / 100 >0) {
            counter = Math.min(checkBillAmount(100),value / 100);
            value = value - 100 * counter;
            cash_map.put(100,counter);
        }

        if(value != 0) {
            return -1;
        }
        cash_map.forEach((k,v) -> {
            if(v>0)
                getBill(k,v);
        });
        return 0;
    }


}
