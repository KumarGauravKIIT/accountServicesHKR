package com.hkr.account.controller;


import com.hkr.account.model.Transaction;
import com.hkr.account.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import javax.transaction.Transactional;

@RestController
@Transactional
public class AccountController {


    @Autowired
    FundTransferService fundTransferService;

    @PostMapping("/transfer-fund")
    public Transaction transferFundFromAccountToAnotherAccount(@RequestBody Transaction transaction){

        return fundTransferService.transferFund(transaction);


    }
}
