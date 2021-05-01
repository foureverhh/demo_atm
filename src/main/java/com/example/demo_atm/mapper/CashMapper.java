package com.example.demo_atm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CashMapper {
    int findAllValue();
    int getOneThousand(int amount);
    int getFiveHundred(int amount);
    int getOneHundred(int amount);
    int checkOneThousandBill();
    int checkFiveHundredBill();
    int checkOneHundredBill();
    int checkBillAmount(int value);
    int getBill(@Param("value") Integer value, @Param("amount") Integer amount);
}
