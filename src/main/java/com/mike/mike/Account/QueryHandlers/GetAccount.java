package com.mike.mike.Account.QueryHandlers;

import com.mike.mike.Account.Account;
import com.mike.mike.Account.AccountRepository;
import com.mike.mike.Exception.ResourceNotFound;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetAccount implements Query<Integer, Account> {

    private final AccountRepository accountRepository;

    public GetAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<Account> execute(Integer id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Account"));
        return ResponseEntity.ok(account);
    }
}
