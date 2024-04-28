package com.javabackend.banking.service.impl;

import com.javabackend.banking.entity.Account;
import com.javabackend.banking.repository.AccountRepository;
import com.javabackend.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(long id){
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @Override
    public Account depositAmount(long id, double amount) {
        Account savedAccount=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
        double totalAmount=savedAccount.getBalance()+amount;
        savedAccount.setBalance(totalAmount);
        return savedAccount;
    }

    @Override
    public Account withdrawAmount(long id,double amount) {
        Account savedAccount=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not Fund"));
        if(amount>savedAccount.getBalance()){
            throw new RuntimeException("Insufficient Amount");
        }
        double remainingAmount=savedAccount.getBalance()-amount;
        savedAccount.setBalance(remainingAmount);
        return savedAccount;
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }


}
