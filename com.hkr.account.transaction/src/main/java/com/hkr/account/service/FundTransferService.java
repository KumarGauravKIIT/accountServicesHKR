package com.hkr.account.service;


import com.hkr.account.model.Account;
import com.hkr.account.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FundTransferService {

    Map<Integer, Account> accountsMap = new HashMap<Integer, Account>();
//    Map<Integer, Account> accountToMap = new HashMap<Integer, Account>();




  public Transaction transferFund(int accountFromId, int accountToId, double amount){

      Account a1 = new Account(12345, "saving", "Hemant", 50000.00);
      Account a2 = new Account(23456, "saving", "Ajay", 50000.00);
      Account a3 = new Account(34567, "saving", "Gaurav", 50000.00);



      accountsMap.put(12345, a1);
      accountsMap.put(23456, a2);
      accountsMap.put(34567, a3);

      Transaction transaction = new Transaction();


          if(accountsMap.containsKey(accountFromId) && accountsMap.containsKey(accountToId)){
              Account fromAcc = accountsMap.get(accountFromId);
              Account toAcc = accountsMap.get(accountToId);


              if(fromAcc.getBalance() > amount){
                  fromAcc.setBalance(fromAcc.getBalance() - amount);
                  toAcc.setBalance(toAcc.getBalance()+amount);
              }

              List<Account> accounts = new ArrayList<>();
              accounts.add(fromAcc);
              accounts.add(toAcc);



              transaction.setAccountList(accounts);





      }

      return transaction;
  }

}
