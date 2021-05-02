package com.example.demo_atm.serivce;

import com.example.demo_atm.mapper.CashMapper;
import com.example.demo_atm.service.CashService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class CashServiceTest {
    @Autowired
    private CashMapper cashMapper;

    CashService cashService = new CashService();

    @Before
    public void setup(){
        cashService.setCashMapper(cashMapper);
    }

    @Test
    public void withdrawTest(){
        // when withdraw 1500, return one 1000 bill, and one 500 bill
        // 1000*1, 500*2, 100*5 left
        Assert.assertEquals(Stream.of(new Integer[][] {{1000,1},{500,1}})
                                .collect(Collectors.toMap(data->data[0], data->data[1])),
                            cashService.withdraw(1500));

        // when withdraw 700,return one 500 bill and 2 100 bill
        // 1000*1, 500*1,100*3 left
        Assert.assertEquals(Stream.of(new Integer[][] {{500,1},{100,2}})
                                .collect(Collectors.toMap(data->data[0],data->data[1])),
                            cashService.withdraw(700));

        // when withdraw 400, return no bill
        // 1000*1, 500*1,100*3 left
        Assert.assertNull(cashService.withdraw(400));

        // when withdraw 1100, return one 1000 bill, one 100 bill
        // 1000*0, 500*1,100*2 left
        Assert.assertEquals(Stream.of(new Integer[][] {{1000,1},{100,1}})
                                .collect(Collectors.toMap(data->data[0],data->data[1])),
                            cashService.withdraw(1100));

        // when withdraw 1000, return no bill
        // 1000*0, 500*1,100*2 left
        Assert.assertNull(cashService.withdraw(1000));

        // when withdraw 700, return one 500 bill, two 100 bills
        // 1000*0, 500*0,100*0 left
        Assert.assertEquals(Stream.of(new Integer[][] {{500,1},{100,2}})
                                .collect(Collectors.toMap(data->data[0],data->data[1])),
                            cashService.withdraw(700));

        // when withdraw 300, return on bill
        // 1000*0, 500*0,100*0 left
        Assert.assertNull(cashService.withdraw(300));
    }

}
