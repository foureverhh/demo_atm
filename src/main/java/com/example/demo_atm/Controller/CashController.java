package com.example.demo_atm.Controller;

import com.example.demo_atm.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/get1000")
    public int getOneThousand(){
        return cashService.getOneThousand();
    }

    @RequestMapping("/get500")
    public int getFiveHundred(){
        return cashService.getFiveHundred();
    }

    @RequestMapping("/get100")
    public int getOneHundred(){
        return cashService.getOneHundred();
    }
    @RequestMapping("/check1000")
    public int checkOneThousand(){
        return cashService.checkOneThousandBill();
    }

    @RequestMapping("/check500")
    public int checkFiveHundred(){
        return cashService.checkFiveHundredBill();
    }

    @RequestMapping("/check100")
    public int checkOneHundred(){
        return cashService.checkOneHundredBill();

    }

    @RequestMapping("/checkAmount")
    public int checkAmount(@RequestParam int value){
        return cashService.checkBillAmount(value);
    }
}