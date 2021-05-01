package com.example.demo_atm.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashMapper {
    int findAllValue();
    int getOneThousand();
    int getFiveHundred();
    int getOneHundred();
    int checkOneThousandBill();
    int checkFiveHundredBill();
    int checkOneHundredBill();
    int checkBillAmount(int value);
}
