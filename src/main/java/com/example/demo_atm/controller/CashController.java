package com.example.demo_atm.controller;

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

    @RequestMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestParam int value){
        return ResponseEntity.ok(cashService.withdraw(value));
    }
}