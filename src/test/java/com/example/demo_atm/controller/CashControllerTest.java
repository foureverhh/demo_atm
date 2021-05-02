package com.example.demo_atm.controller;

import com.example.demo_atm.domain.Cash;
import com.example.demo_atm.mapper.CashMapper;
import com.example.demo_atm.service.CashService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CashController.class)
public class CashControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CashService cashService;

    @Test
    public void withdraw() throws Exception {
        when(cashService.withdraw(1500)).thenReturn(Stream.of(new Integer[][]{{500,1},{1000,1}})
                                              .collect(Collectors.toMap(data->data[0],data->data[1])),null);
        MvcResult mvcResult = mockMvc.perform(get("/cash/withdraw").param("value","1500"))
                                    .andReturn();
        String body = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("{"+"\""+"500"+"\""+":1,"+"\""+"1000\""+":1}",body);
        mvcResult = mockMvc.perform(get("/cash/withdraw").param("value","1500"))
                .andReturn();
        body = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue(body.isEmpty());
    }
}