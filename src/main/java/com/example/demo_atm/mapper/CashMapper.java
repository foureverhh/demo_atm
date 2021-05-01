package com.example.demo_atm.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashMapper {
    int findAllValue() ;
}
