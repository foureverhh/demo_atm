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
        int[] cash = new int[3];
        if(value == 0)
            return 0;

        if(value > findAllValue())
            return -1;

        if(value / 1000 >0) {
            cash[0] = Math.min(checkBillAmount(1000),value / 1000);
            value = value - 1000 * cash[0];
        }

        if(value / 500 >0){
            cash[1] = Math.min(checkBillAmount(500),value / 500);
            value = value - 500 * cash[1];
        }

        if(value / 100 >0) {
            cash[2] = Math.min(checkBillAmount(100),value / 100);
            value = value - 100 * cash[2];
        }
        if(value != 0) {
            return -1;
        }
        if (cash[0] > 0)
            getBill(1000,cash[0]);
        if (cash[1] > 0)
            getBill(500,cash[1]);
        if (cash[2] > 0)
            getBill(100,cash[2]);
        return 0;
    }


}
