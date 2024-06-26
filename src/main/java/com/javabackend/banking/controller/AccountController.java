package com.javabackend.banking.controller;

import com.javabackend.banking.entity.Account;
import com.javabackend.banking.service.impl.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id){
        Account account=service.getAccount(id);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<Account> depositAmount(@PathVariable long id, @RequestBody Map<String,Integer> request){
        Account savedAccount=service.depositAmount(id,request.get("amount"));
        return ResponseEntity.ok(savedAccount);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdrawAmount(@PathVariable long id, @RequestBody Map<String,Integer>request){
        Account savedAccount=service.withdrawAmount(id,request.get("amount"));
        return ResponseEntity.ok(savedAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount(){
        List<Account> allAccounts=service.getAllAccount();
        return ResponseEntity.ok(allAccounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletAccount(@PathVariable long id){
        service.deleteAccountById(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }
}
