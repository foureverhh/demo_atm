package com.example.demo_atm.Controller;

import com.example.demo_atm.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cash")
public class CashController {
    @Autowired
    private CashService cashService;

    @RequestMapping("/all")
    public int findAllValue(){
        return cashService.findAllValue();
    }
}
