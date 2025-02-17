package com.mike.mike.Account.CommandHandlers;

import com.mike.mike.Account.Account;
import com.mike.mike.Account.AccountRepository;
import com.mike.mike.Command;
import com.mike.mike.SuccessResponse.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddAccount implements Command <Account, SuccessResponse>{

    private final AccountRepository accountRepository;

    public AddAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<SuccessResponse> execute(Account account) {
        accountRepository.save(account);

        return ResponseEntity.ok(new SuccessResponse("true", "Account added successfully"));
    }
}
