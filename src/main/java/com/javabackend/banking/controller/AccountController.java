package com.javabackend.banking.controller;

import com.javabackend.banking.entity.Account;
import com.javabackend.banking.service.impl.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountServiceImpl service;

    public AccountController(AccountServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(service.createAccount(account), HttpStatus.CREATED);
    }
}
