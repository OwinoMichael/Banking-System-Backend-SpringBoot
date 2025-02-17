package com.mike.mike.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private  AccountRepository accountRepository;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> account = accountRepository.findAll();
        return ResponseEntity.ok(account);
    }


}
