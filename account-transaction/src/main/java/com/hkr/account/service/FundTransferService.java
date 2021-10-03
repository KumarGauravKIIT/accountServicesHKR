package com.hkr.account.service;


import com.hkr.account.model.Account;
import com.hkr.account.model.Transaction;
import com.hkr.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class FundTransferService {

    @Autowired
    AccountRepository repository;

      public Transaction transferFund(Transaction transaction){

        Long accountFromId = 0L;
        Long accountToId = 0L;
        Double amount = 0.0;

        if (transaction.getAccountList().size() == 2){
            accountFromId = transaction.getAccountList().get(0).getAccId();
            accountToId = transaction.getAccountList().get(1).getAccId();
            amount = transaction.getAmount();
        }


        Optional<Account> fromAcc = repository.findById(accountFromId);

        Optional<Account> toAcc = repository.findById(accountToId);


        try {
            if (fromAcc.isPresent() && toAcc.isPresent()) {
                Account from = fromAcc.get();
                Account to = toAcc.get();

                if (from.getBalance() > amount) {
                    from.setBalance(from.getBalance() - amount);
                    to.setBalance(to.getBalance() + amount);
                }else{
                    
                }

                repository.save(from);
                repository.save(to);

                List<Account> accounts = new ArrayList<>();

                accounts.add(from);
                accounts.add(to);

                transaction.setAccountList(accounts);
                transaction.setAmount(amount);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return transaction;
    }

}
