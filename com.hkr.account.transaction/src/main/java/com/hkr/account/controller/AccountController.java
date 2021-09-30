package com.hkr.account.controller;


import com.hkr.account.model.Transaction;
import com.hkr.account.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @Autowired
    FundTransferService fundTransferService;

    @GetMapping("/transfer-fund-from-{accountFrom}-to-{accountTo}-{amount}")
    public Transaction transferFundFromAccountToAnotherAccount(@PathVariable int accountFrom, @PathVariable int accountTo, @PathVariable double amount){

        return fundTransferService.transferFund(accountFrom, accountTo, amount);


    }
}
