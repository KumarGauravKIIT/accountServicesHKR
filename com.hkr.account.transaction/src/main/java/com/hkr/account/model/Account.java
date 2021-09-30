package com.hkr.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



public class Account implements Serializable {

    private static final Long serialUID = 4324353224123L;


    private int accId;

    private String accType;

    private String accHolderName;

    private Double balance;

//    Map<Integer, Account> accountFromMap = new HashMap<Integer, Account>();
//    Map<Integer, Account> accountToMap = new HashMap<Integer, Account>();


    public Account(){}

    public Account(int accId, String accType, String accHolderName, Double balance) {
        this.accId = accId;
        this.accType = accType;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

//    public Map<Integer, Account> getAccountFromMap() {
//        return accountFromMap;
//    }
//
//    public void setAccountFromMap(Map<Integer, Account> accountFromMap) {
//        this.accountFromMap = accountFromMap;
//    }
//
//    public Map<Integer, Account> getAccountToMap() {
//        return accountToMap;
//    }
//
//    public void setAccountToMap(Map<Integer, Account> accountToMap) {
//        this.accountToMap = accountToMap;
//    }



}
