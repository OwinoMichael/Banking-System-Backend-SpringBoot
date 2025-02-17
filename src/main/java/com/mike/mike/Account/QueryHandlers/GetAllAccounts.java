package com.mike.mike.Account.QueryHandlers;

import com.mike.mike.Account.Account;
import com.mike.mike.Account.AccountRepository;
import com.mike.mike.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAccounts implements Query<Void, List<Account>> {

    private final AccountRepository accountRepository;

    public GetAllAccounts(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<List<Account>> execute(Void input) {
        List<Account> accounts = accountRepository.findAll();
        return ResponseEntity.ok(accounts);
    }
}
