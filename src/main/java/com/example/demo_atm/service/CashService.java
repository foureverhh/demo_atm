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
     * @param withdraw is the amount of money, one choose to get from atm
     * @return a combination of bills with different withdraw
     */
    public Map withdraw(int withdraw) {

        Map<Integer,Integer> cash_map = new HashMap<>();
        if(withdraw == 0)
            return null;

        //The ATM can't give out more money than it contains
        if(withdraw > findAllValue())
            return null;

        //The ATM can't give out amounts that the remaining bills don’t add up to
        withdraw = dispatchBills(cash_map,1000,withdraw);
        withdraw = dispatchBills(cash_map,500,withdraw);
        withdraw = dispatchBills(cash_map,100,withdraw);

        //The ATM can't give out amounts that the remaining bills don’t add up to
        if(withdraw != 0) {
            return null;
        }

        //The bills used for withdrawal is removed from the ATM
        cash_map.forEach((k,v) -> {
            if(v>0)
                getBill(k,v);
        });

        return cash_map;
    }

    private int dispatchBills(Map<Integer,Integer> cash_map, int value, int withdraw){
        int amount = 0;
        if(withdraw / value > 0){
            amount = Math.min(withdraw / value, checkBillAmount(value));
            withdraw = withdraw - amount * value;
            cash_map.put(value,amount);
        }
        return withdraw;
    }
}
