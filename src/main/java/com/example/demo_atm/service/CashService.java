package com.example.demo_atm.service;

import com.example.demo_atm.mapper.CashMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CashService {
    private CashMapper cashMapper;

    @Autowired
    public void setCashMapper(CashMapper cashMapper) {
        this.cashMapper = cashMapper;
    }

    public int findAllValue(){
        return cashMapper.findAllValue();
    }

    public int checkBillAmount(int value){
        return cashMapper.checkBillAmount(value);
    }

    /**
     * This method is to bills from database atm.cash
     * @param value determines what kind of bill going to be get from database
     * @param amount determines quantity of bill going to be get from database
     * @return how many types bill updated in the database
     */
    public int getBill(int value,int amount){
        return cashMapper.getBill(value,amount);
    }

    /**
     * This method is to determine which combination of bills to withdraw
     * @param value is the amount of money, one choose to get from atm
     * @return a combination of bills with different value
     */
    public Map withdraw(int value) {
        int counter = 0;
        Map<Integer,Integer> cash_map = new HashMap<>();
        if(value == 0)
            return null;

        if(value > findAllValue())
            return null;

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
            return null;
        }
        cash_map.forEach((k,v) -> {
            if(v>0)
                getBill(k,v);
        });
        return cash_map;
    }
}
