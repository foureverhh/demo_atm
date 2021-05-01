package com.example.demo_atm.Controller;

import com.example.demo_atm.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/checkAmount")
    public int checkAmount(@RequestParam int value){
        return cashService.checkBillAmount(value);
    }

    @RequestMapping("/get1000")
    public int getOneThousand(@RequestParam int amount){
        return cashService.getOneThousand(amount);
    }

    @RequestMapping("/get500")
    public int getFiveHundred(@RequestParam int amount){
        return cashService.getFiveHundred(amount);
    }

    @RequestMapping("/get100")
    public int getOneHundred(@RequestParam int amount){
        return cashService.getOneHundred(amount);
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


    @RequestMapping("/withdraw")
    public int withdraw(@RequestParam int value){
        return cashService.withdraw(value);
    }

    @RequestMapping("/getBill")
    public int getBill(@RequestParam int value,@RequestParam int amount){
        return cashService.getBill(value,amount);
    }
}