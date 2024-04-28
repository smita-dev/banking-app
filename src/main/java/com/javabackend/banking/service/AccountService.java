package com.javabackend.banking.service;

import com.javabackend.banking.entity.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccount(long id);
}
