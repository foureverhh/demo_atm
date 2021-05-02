package com.example.demo_atm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface CashMapper {
    int findAllValue();
    int checkBillAmount(int value);
    @Transactional
    int getBill(@Param("value") Integer value, @Param("amount") Integer amount);
}
