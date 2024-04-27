package com.javabackend.banking.service.impl;

import com.javabackend.banking.entity.Account;
import com.javabackend.banking.repository.AccountRepository;
import com.javabackend.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public Account createAccount(Account account) {
        Account savedAccount=accountRepository.save(account);
        return savedAccount;
    }
}
