package com.javabackend.banking.service;

import com.javabackend.banking.entity.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccount(long id);
    Account depositAmount(long id, double amount);
    Account withdrawAmount(long id,double amount);
    List<Account> getAllAccount();
    void deleteAccountById(long id);
}
